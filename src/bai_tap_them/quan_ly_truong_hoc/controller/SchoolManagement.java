package bai_tap_them.quan_ly_truong_hoc.controller;

import bai_tap_them.quan_ly_truong_hoc.service.IService;
import bai_tap_them.quan_ly_truong_hoc.service.PersonServiceImpl;

import java.util.Scanner;

public class SchoolManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        IService service = new PersonServiceImpl();
        String choose;
        do {
            System.out.println("--SCHOOL MANAGEMENT--");
            System.out.println("1. Display list");
            System.out.println("2. Add new");
            System.out.println("3. Remove by ID");
            System.out.println("4. Sort");
            System.out.println("5. Edit");
            System.out.println("6. Exit");
            System.out.println("Enter your choose:");

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
                    service.sort();
                    break;
                case "5":
                    service.edit();
                    break;
                case "6":
                    System.exit(6);
                default:
                    System.out.println("Inpun incorrect. Try again!");
            }
        } while (true);
    }

}
