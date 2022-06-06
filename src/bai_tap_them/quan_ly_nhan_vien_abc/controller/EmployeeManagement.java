package bai_tap_them.quan_ly_nhan_vien_abc.controller;

import bai_tap_them.quan_ly_nhan_vien_abc.service.EmployeeServiceImpl;
import bai_tap_them.quan_ly_nhan_vien_abc.service.IService;

import java.util.Scanner;

public class EmployeeManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        IService service = new EmployeeServiceImpl();
        String choose;
        do {
            System.out.println("--ABC EMPLOYEE MANAGEMENT--");
            System.out.println("1. Display employee list");
            System.out.println("2. Add new employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Find employee");
            System.out.println("5. Exit");
            System.out.println("Enter your choose: ");
            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    service.display();
                    break;
                case "2":
                    service.add();
                    break;
                case "3":
                    service.remove();
                    break;
                case "4":
                    service.find();
                    break;
                case "5":
                    System.exit(5);
                default:
                    System.out.println("Your choose is incorrect! Choose again!");
            }
        } while (true);
    }
}
