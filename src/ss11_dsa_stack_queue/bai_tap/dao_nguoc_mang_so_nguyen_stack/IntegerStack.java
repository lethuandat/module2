package ss11_dsa_stack_queue.bai_tap.dao_nguoc_mang_so_nguyen_stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class IntegerStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập số lượng phần tử của mảng số nguyên:");
        int numb = Integer.parseInt(input.nextLine());
        int[] arr = new int[numb];

        for (int i = 0; i < numb; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = Integer.parseInt(input.nextLine());
        }

        System.out.println("Mảng lúc ban đầu: ");
        for (int item : arr) {
            System.out.println(item);
        }

        Stack<Integer> intStack = new Stack<>();
        for (int value : arr) {
            intStack.push(value);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = intStack.pop();
        }

        System.out.println("\nMảng lúc sau: " + Arrays.toString(arr));
    }
}
