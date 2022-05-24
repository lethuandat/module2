package ss14_thuat_toan_sap_xep.bai_tap.minh_hoa_sap_xep_chen;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void insertionSortByStep(int[] array) {
        int pos;
        int x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;
            System.out.println("Vòng lặp " + i + ": ");
            while (pos > 0 && x < array[pos - 1]) {
                System.out.println("Gán " + array[pos - 1] + " cho " + array[pos]);
                array[pos] = array[pos - 1];
                pos--;
            }
            System.out.println("Gán " + x + " cho " + array[pos]);
            array[pos] = x;
            System.out.println("Mảng sau vòng lặp  " + i);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng:");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];
        System.out.println("Nhập " + array.length + " phần tử:");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Mảng ban đầu: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }

        System.out.println("\nBắt đầu sắp xếp chèn: ");
        insertionSortByStep(array);
    }
}
