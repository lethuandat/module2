package ss14_thuat_toan_sap_xep.bai_tap.minh_hoa_sap_xep_chen;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void insertionSortByStep(int[] array) {
        int pos;
        int x;
        boolean needNextPass;
        for (int i = 1; i < array.length; i++) {
            needNextPass = false;
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                System.out.println("Assign " + array[pos - 1] + " for " + array[pos]);
                array[pos] = array[pos - 1];
                pos--;
                needNextPass = true;
            }
            array[pos] = x;

            if (!needNextPass) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }

            System.out.print("Array after the  " + i + "' sort: ");
            for (int value : array) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size:");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];
        System.out.println("Enter " + array.length + " values:");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Your input array: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }

        System.out.println("\nBegin sort processing...");
        insertionSortByStep(array);
    }
}
