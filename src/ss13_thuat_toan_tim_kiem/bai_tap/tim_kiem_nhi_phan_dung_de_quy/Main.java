package ss13_thuat_toan_tim_kiem.bai_tap.tim_kiem_nhi_phan_dung_de_quy;

import java.util.Scanner;

public class Main {
    public static int binarySearch(int[] array, int left, int right, int value) {
        while (right >= left) {
            int middle = (left + right) / 2;
            if (value == array[middle]) {
                return middle;
            } else if (value > array[middle]) {
                left = middle + 1;
                binarySearch(array, left, right, value);
            } else {
                right = middle - 1;
                binarySearch(array, left, right, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử:");
        int number = Integer.parseInt(input.nextLine());
        int[] arrNumber = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập phần tử " + (i + 1) + ":");
            arrNumber[i] = Integer.parseInt(input.nextLine());
        }

        System.out.println("Mảng số nguyên ban đầu:");
        for (int value : arrNumber) {
            System.out.print(value + " ");
        }

        for (int i = 0; i < arrNumber.length - 1; i++) {
            for (int j = i + 1; j < arrNumber.length; j++) {
                if (arrNumber[i] > arrNumber[j]) {
                    int temp = arrNumber[i];
                    arrNumber[i] = arrNumber[j];
                    arrNumber[j] = temp;
                }
            }
        }

        System.out.println("\nMảng số nguyên sắp xếp tăng dần:");
        for (int value : arrNumber) {
            System.out.print(value + " ");
        }
        System.out.println("\nNhập phần tử cần tìm:");
        int valueSearch = Integer.parseInt(input.nextLine());
        int result = binarySearch(arrNumber, 0, arrNumber.length - 1, valueSearch);
        if (result == -1) {
            System.out.println(valueSearch + " không có trong mảng.");
        } else {
            System.out.println(valueSearch + " nằm ở vị trí thứ " + result);
        }

    }
}
