package bai_tap_them.quan_ly_benh_an.controller;

import bai_tap_them.quan_ly_benh_an.service.IService;
import bai_tap_them.quan_ly_benh_an.service.PatientServiceImpl;

import java.util.Scanner;

public class PatientManagement {
    public static Scanner scanner = new Scanner(System.in);
    static IService service = new PatientServiceImpl();

    public static void displayMenu() {
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--");
            System.out.println("Chọn chức năng theo số dể tiếp tục: ");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách bệnh án");
            System.out.println("4. Thoát");
            System.out.println("Chọn chức năng: ");

            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    service.add();
                    break;
                case "2":
                    service.remove();
                    break;
                case "3":
                    service.display();
                    break;
                case "4":
                    System.exit(4);
                default:
                    System.out.println("Chọn chức năng sai, mời chọn lại.");
                    displayMenu();
            }
        } while (true);
    }
}
