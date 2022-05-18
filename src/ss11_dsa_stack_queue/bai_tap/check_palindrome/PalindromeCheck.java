package ss11_dsa_stack_queue.bai_tap.check_palindrome;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra:");
        String str = input.nextLine();

        String[] arrStr = str.split(" ");
        Stack<String> stack = new Stack<>();

        for (String s : arrStr) {
            stack.push(s);
        }

        String[] arrStr2 = new String[arrStr.length];
        for (int i = 0; i < arrStr2.length; i++) {
            arrStr2[i] = stack.pop();
        }

        int count = 0;
        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i].equals(arrStr2[i])) {
                count++;
            }
        }

        if (count == arrStr.length) {
            System.out.println("Đây là chuỗi palidrome");
        } else {
            System.out.println("Đây không phải là chuỗi palidrome");
        }
    }
}
