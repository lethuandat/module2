package bai_tap_them.quan_ly_tien_dien.exception;

import java.util.Scanner;

public class MyException {
    static Scanner scanner = new Scanner(System.in);

    public static int checkParseInt() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }

    public static Double checkParseDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }

    public static String checkString() {
        String value;
        while (true) {
            try {
                value = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }
}
