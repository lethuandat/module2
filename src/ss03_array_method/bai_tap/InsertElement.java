package ss03_array_method.bai_tap;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        int[] arrays = {10, 4, 6, 7, 8, 7, 9, 1, 5, 2, 15};

        Scanner scanner = new Scanner(System.in);
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int item : arrays) {
            System.out.print(item + "\t");
        }

        System.out.print("\nInput element need insert: ");
        int x = scanner.nextInt();

        System.out.print("Input index element need insert: ");
        int indexInsert = scanner.nextInt();

        if (indexInsert <= -1 || indexInsert > arrays.length - 1) {
            System.out.println("Not allow add element to array.");
        } else {
            for (int i = arrays.length - 1; i > indexInsert; i--) {
                arrays[i] = arrays[i - 1];
            }
            arrays[indexInsert] = x;
            System.out.printf("%-20s%s", "Elements after: ", "");
            for (int item : arrays) {
                System.out.print(item + "\t");
            }
        }
    }
}
