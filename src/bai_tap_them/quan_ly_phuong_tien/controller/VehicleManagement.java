package bai_tap_them.quan_ly_phuong_tien.controller;

import bai_tap_them.quan_ly_phuong_tien.service.IService;
import bai_tap_them.quan_ly_phuong_tien.service.VehicleServiceImpl;

import java.util.Scanner;

public class VehicleManagement {
    public static Scanner scanner = new Scanner(System.in);
    static IService service = new VehicleServiceImpl();

    public static void displayMenu() {
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG--");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thoát");
            System.out.println("Chọn chức năng: ");

            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    service.add();
                    break;
                case "2":
                    service.display();
                    break;
                case "3":
                    service.remove();
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
