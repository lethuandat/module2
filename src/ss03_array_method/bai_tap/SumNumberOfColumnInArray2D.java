package ss03_array_method.bai_tap;

import java.util.Scanner;

public class SumNumberOfColumnInArray2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chiều dài mảng 2 chiều:");
        int width = Integer.parseInt(input.nextLine());
        System.out.println("Nhập chiều rộng mảng 2 chiều:");
        int height = Integer.parseInt(input.nextLine());

        int[][] array2D = new int[width][];
        for (int i = 0; i < width; i++) {
            array2D[i] = new int[height];
            for (int j = 0; j < height; j++) {
                System.out.print("Nhập phần tử thứ " + i + "-" + j + ": ");
                array2D[i][j] = Integer.parseInt(input.nextLine());
            }
        }

        System.out.println("Mảng 2 chiều: ");
        for (int[] ints : array2D) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }

        int sumColumn = 0;
        System.out.print("Nhập cột muốn tính tổng: ");
        int column = Integer.parseInt(input.nextLine());

        for (int[] ints : array2D) {
            sumColumn += ints[column];
        }

        System.out.print("Tổng giá trị các phần tử cột " + column + " là: " + sumColumn);
    }

}
