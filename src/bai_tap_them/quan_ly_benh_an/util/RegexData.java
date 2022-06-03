package bai_tap_them.quan_ly_benh_an.util;

import java.util.Scanner;

public class RegexData {
    static Scanner input = new Scanner(System.in);

    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = input.nextLine();
            }
        } while (check);
        return temp;
    }
}
