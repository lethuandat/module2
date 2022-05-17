package ss11_dsa_stack_queue.bai_tap.dao_nguoc_mang_so_nguyen_stack;

import java.util.Scanner;
import java.util.Stack;

public class StringStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String mWord = input.nextLine();

        String[] arrString = mWord.split("");

        Stack<String> wStack = new Stack<>();

        for (String s : arrString) {
            wStack.push(s);
        }

        String newStr = "";
        for (int i = 0; i < arrString.length; i++) {
            newStr += wStack.pop();
        }

        System.out.println("Chuỗi sau khi đảo ngược: " + newStr);
    }
}

