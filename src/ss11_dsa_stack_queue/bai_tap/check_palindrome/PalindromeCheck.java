package ss11_dsa_stack_queue.bai_tap.check_palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra:");
        String str = input.nextLine();

        String[] arrStr = str.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        for (String s : arrStr) {
            stack.push(s);
            queue.add(s);
        }

        boolean check = false;
        while (!stack.isEmpty()) {
            if (stack.pop().equals(queue.poll())) {
                check = true;
            }
        }

        if (check) {
            System.out.println("Đây là chuỗi palidrome");
        } else {
            System.out.println("Đây không phải là chuỗi palidrome");
        }
    }
}
