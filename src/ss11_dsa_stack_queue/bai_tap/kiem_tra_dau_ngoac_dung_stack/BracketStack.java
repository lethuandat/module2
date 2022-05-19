package ss11_dsa_stack_queue.bai_tap.kiem_tra_dau_ngoac_dung_stack;

import java.util.Scanner;
import java.util.Stack;

public class BracketStack {
    public static void main(String[] args) {
        Stack<String> bStack = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập biểu thức cần kiểm tra:");
        String sym = input.nextLine();
        String[] arr = sym.split("");
        boolean check = true;
        for (String s : arr) {
            if (s.equals("(")) {
                bStack.push(s);
            } else if (s.equals(")")) {
                if (bStack.isEmpty()) {
                    check = false;
                } else {
                    String left = bStack.peek();
                    if (left.equals("(")) {
                        bStack.pop();
                    }
                }
            }
        }
        if (bStack.size() > 0) {
            check = false;
        }
        if (check) {
            System.out.println("Biểu thức sử dụng đúng dấu ngoặc.");
        } else {
            System.out.println("Biểu thức sử dụng sai dấu ngoặc.");
        }
    }
}
