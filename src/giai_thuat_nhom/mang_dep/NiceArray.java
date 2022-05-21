package giai_thuat_nhom.mang_dep;

import java.util.Arrays;

public class NiceArray {
    private static boolean checkNiceArray(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += array[j];
            }
            for (int k = array.length - 1; k > i; k--) {
                sum2 += array[k];
            }
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3, 3};
        System.out.println(Arrays.toString(arr1));
        if (checkNiceArray(arr1)) {
            System.out.println("-> Mảng đẹp");
        } else {
            System.out.println("-> Mảng xấu");
        }
        System.out.println(Arrays.toString(arr2));
        if (checkNiceArray(arr2)) {
            System.out.println("-> Mảng đẹp");
        } else {
            System.out.println("-> Mảng xấu");
        }
    }
}
