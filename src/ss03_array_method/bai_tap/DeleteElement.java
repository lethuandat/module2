package bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arrays = {10, 4, 6, 7, 8, 7, 9, 1, 5, 2};

        Scanner input = new Scanner(System.in);
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int item : arrays) {
            System.out.print(item + "\t");
        }

        System.out.print("\nInput element need delete: ");
        int x = input.nextInt();
        int indexDel = 0;
        boolean check = false;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == x) {
                indexDel = i;
                check = true;
                break;
            }
        }
        if (check) {
            for (int i = indexDel; i < arrays.length - 1; i++) {
                arrays[i] = arrays[i + 1];
            }
            System.out.printf("%-20s%s", "Elements after: ", "");
            for (int item : arrays) {
                System.out.print(item + "\t");
            }
        } else {
            System.out.println(x + " have not in array.");
        }
    }
}
