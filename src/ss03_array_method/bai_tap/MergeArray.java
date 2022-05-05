package bai_tap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array1 = new int[5];
        System.out.println("Input elements of array 1:");
        for (int i = 0; i < array1.length; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array1[i] = input.nextInt();
        }

        int[] array2 = new int[5];
        System.out.println("Input elements of array 2:");
        for (int i = 0; i < array2.length; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array2[i] = input.nextInt();
        }

        System.out.print("Array 1: ");
        for (int value1 : array1) {
            System.out.print(value1 + " ");
        }
        System.out.print("\nArray 2: ");
        for (int value2 : array2) {
            System.out.print(value2 + " ");
        }
    }
}
