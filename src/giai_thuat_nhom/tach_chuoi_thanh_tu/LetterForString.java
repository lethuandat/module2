package giai_thuat_nhom.tach_chuoi_thanh_tu;

import java.util.Scanner;

public class LetterForString {
    public static String solution(String s) {
        char x = s.toLowerCase().charAt(0);
        String str = "";
        str += x;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.toUpperCase().charAt(i)) {
                str += " ";
                str += s.toLowerCase().charAt(i);
            } else {
                str += s.charAt(i);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Input string:");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(solution(s));
    }
}
