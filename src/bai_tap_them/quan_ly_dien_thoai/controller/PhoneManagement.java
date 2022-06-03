package bai_tap_them.quan_ly_dien_thoai.controller;

import bai_tap_them.quan_ly_dien_thoai.service.IService;
import bai_tap_them.quan_ly_dien_thoai.service.PhoneServiceImpl;

import java.util.Scanner;

public class PhoneManagement {
    public static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        IService iService = new PhoneServiceImpl();
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI –-");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.println("Chọn chức năng");

            String chosen = scanner.nextLine();
            switch (chosen) {
                case "1":
                    iService.add();
                    break;
                case "2":
                    iService.remove();
                    break;
                case "3":
                    iService.display();
                    break;
                case "4":
                    iService.search();
                    break;
                case "5":
                    System.exit(5);
                    break;
                default:
                    System.out.println("Chọn sai, chọn lại đi.");
            }
        } while (true);
    }
}
