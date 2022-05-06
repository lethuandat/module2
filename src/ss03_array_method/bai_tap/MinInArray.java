package ss03_array_method.bai_tap;

import java.util.Scanner;

public class MinInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size: ");
        int size = Integer.parseInt(scanner.nextLine());

        int[] array = new int[size];

        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + " : ");
            array[i] = Integer.parseInt(scanner.nextLine());
            i++;
        }

        System.out.print("Array list: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }

        int min = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }

        System.out.println("\nMin in array is: " + min);
    }
}
