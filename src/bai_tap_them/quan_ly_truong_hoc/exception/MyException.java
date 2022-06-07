package bai_tap_them.quan_ly_truong_hoc.exception;

import bai_tap_them.quan_ly_truong_hoc.utils.RegexData;

import java.util.Scanner;

public class MyException {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_POSITIVE = "[1-9][0-9]*";
    public static final String REGEX_POSITIVE_DOUBLE = "^[0-9]{1,2}[.]{1}[0-9]{1}$";

    public static int checkParseInt() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE, "Input must > 0"));
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Try again!");
            }
        }
        return value;
    }

    public static Double checkParseDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE_DOUBLE, "Input wrong."));
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Try again!");
            }
        }
        return value;
    }
}
