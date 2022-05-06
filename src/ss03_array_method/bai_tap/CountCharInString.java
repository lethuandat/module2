package ss03_array_method.bai_tap;

import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        String str = "Codegym codegym CODEGYM";
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập kí tự muốn tìm kiếm: ");
        char ch = input.nextLine().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        System.out.println("Có " + count + " kí tự " + ch + " trong chuỗi.");
    }
}
