package bai_tap_them.quan_ly_nhan_vien_2.controller;

import bai_tap_them.quan_ly_nhan_vien_2.service.EmployLinkedListImpl;
import bai_tap_them.quan_ly_nhan_vien_2.service.EmployeeArrayImpl;
import bai_tap_them.quan_ly_nhan_vien_2.service.EmployeeArrayListImpl;

import java.util.Scanner;

public class EmployeeManagement {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeArrayImpl employeeArray = new EmployeeArrayImpl();
    static EmployeeArrayListImpl employeeArrayList = new EmployeeArrayListImpl();
    static EmployLinkedListImpl employLinkedList = new EmployLinkedListImpl();

    public static void displayMainMenu() {
        do {
            System.out.println("1. Hiển thị nhân viên dùng Array.");
            System.out.println("2. Hiển thị nhân viên dùng ArrayList.");
            System.out.println("3. Hiển thị nhân viên dùng LinkedList.");
            System.out.println("4. Sắp xếp ");
            System.out.println("5. Hiển thị nhân viên dùng Linked HashMap");
            System.out.println("6. Thoát.");
            System.out.println("Chọn cách hiển thị:");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("1. Hiển thị nhân viên dùng Array:");
                    employeeArray.displayEmployeeArray();
                    break;
                case 2:
                    System.out.println("2. Hiển thị nhân viên dùng ArrayList:");
                    employeeArrayList.displayEmployeeArrayList();
                    break;
                case 3:
                    System.out.println("3. Hiển thị nhân viên dùng LinkedList:");
                    employLinkedList.displayEmployeeLinkedList();
                    break;
                case 4:
                    do {
                        //Có thể dùng sắp xếp lương tăng dần dùng comparator, tên tăng dần dùng comparable
                        //Hoặc cả 2 đều dùng comparator với các class implements comparator với tiêu chí khác nhau
                        //Khi chỉ có 1 tiêu chí, dùng comparable cho gọn, không phải tạo thêm class
                        //Khi có 2 tiêu chí trở lên, phải dùng comparator
                        //Comparable triển khai ngay trong class cần sắp xếp -> ghi đè phương thức compareTo, chỉ sắp xếp theo 1 tiêu chí, thuộc thư viện java.lang
                        //Comparator tạo 1 class mới rồi triển khai comparator -> ghi đè phương thức compare, từ 2 tiêu chí trở lên, bắt buộc dùng comparator, thuộc thư viện java.util
                        System.out.println("1. Sắp xếp theo lương tăng dần.");
                        System.out.println("2. Sắp xếp theo tên tăng dần.");
                        System.out.println("3. Quay lại menu chính.");
                        System.out.println("Chọn cách sắp xếp:");
                        int input = Integer.parseInt(scanner.nextLine());
                        switch (input) {
                            case 1:
                                System.out.println("Sắp xếp theo lương (dùng array list): ");
                                employLinkedList.sortBySalary();
                                employLinkedList.displayEmployeeLinkedList();
                                break;
                            case 2:
                                System.out.println("Sắp xếp theo tên (dùng linked list): ");
                                employLinkedList.sortByName();
                                employLinkedList.displayEmployeeLinkedList();
                                break;
                            case 3:
                                displayMainMenu();
                                break;
                            default:
                                System.out.println("Nhập lựa chọn sai.");
                        }
                    } while (true);
                case 5:
                    System.out.println("Hiển thị nhân viên dùng LinkedHashMap:");
                    employLinkedList.displayByLinkedHashMap();
                    break;
                case 6:
                    System.exit(6);
                default:
                    System.out.println("Chọn sai!");
            }
        } while (true);
    }
}
