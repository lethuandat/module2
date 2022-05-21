package giai_thuat_nhom.hinh_thoi_rong;

import java.util.Scanner;

public class NullRhombus {
    public static void printBodyRhombus(int i, int n) {
        for (int j = 1; j <= 2 * n; j++) {
            if (j == n - i + 1 || j == n + i) {
                System.out.printf("%2d",i);
            } else {
                System.out.print("  ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("---------Vẽ hình thoi---------");
        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.print("Nhập n = ");
            n = Integer.parseInt(input.nextLine());
            if (n <= 1) {
                System.out.println("n phải lớn hơn 1 mới vẽ hình được.");
            } else {
                //Nửa trên
                for (int i = 1; i <= n; i++) {
                    printBodyRhombus(i, n);
                    System.out.println();
                }
                //Nửa dưới
                for (int i = n - 1; i >= 1; i--) {
                    printBodyRhombus(i, n);
                    System.out.println();
                }
                break;
            }
        } while (true);
    }
}
