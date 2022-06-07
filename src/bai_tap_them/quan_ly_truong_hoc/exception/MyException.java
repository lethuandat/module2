package bai_tap_them.quan_ly_truong_hoc.exception;

import bai_tap_them.quan_ly_truong_hoc.utils.RegexData;

import java.util.Scanner;

public class MyException {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_POSITIVE = "[1-9][0-9]*";
    public static final String REGEX_POSITIVE_POINT = "^[0-9]{1,2}[.]{1}[0-9]{1}$";

    public static int checkParseInt() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE, "Input must > 0"));
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                System.out.print("Try again!");
            }
        }
        return value;
    }

    public static Double checkPoint() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE_POINT, "Input wrong."));
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                System.out.print("Try again!");
            }
        }
        return value;
    }

    public static Double checkParseDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE, "Input wrong."));
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                System.out.print("Try again!");
            }
        }
        return value;
    }

    public static String checkStr() {
        String value;
        while (true) {
            try {
                value = scanner.nextLine();
                if (value.equals("")) {
                    throw new NullStringException("Input string not null.");
                }
                break;
            } catch (NullStringException e) {
                System.err.println(e.getMessage());
                System.out.println("Try again!");
            }
        }
        return value;
    }
}
