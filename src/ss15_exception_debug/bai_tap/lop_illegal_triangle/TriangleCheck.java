package ss15_exception_debug.bai_tap.lop_illegal_triangle;

import java.util.Scanner;

public class TriangleCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TriangleCheck triangleCheck = new TriangleCheck();
        boolean check;
        System.out.println("Nhập độ dài 3 cạnh của tam giác: ");
        double edge1;
        double edge2;
        double edge3;
        do {
            check = false;
            try {
                System.out.println("Nhập cạnh thứ nhất ");
                edge1 = Double.parseDouble(input.nextLine());
                System.out.println("Nhập cạnh thứ 2 ");
                edge2 = Double.parseDouble(input.nextLine());
                System.out.println("Nhập cạnh thứ 3 ");
                edge3 = Double.parseDouble(input.nextLine());
                triangleCheck.checkTriangle(edge1, edge2, edge3);
            } catch (IllegalTriangleException e) {
                check = true;
                System.out.println("Nhập lại:");
            } catch (NumberFormatException e) {
                check = true;
                System.out.println("Không được nhập kí tự, nhập lại.");
            }
        } while (check);

    }

    private void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Lỗi, cạnh tam giác phải lớn hơn 0!");
        } else if (a + b <= c) {
            throw new IllegalTriangleException("Lỗi, tổng 2 cạnh a và b phải lớn hơn cạnh c");
        } else if (a + c <= b) {
            throw new IllegalTriangleException("Lỗi, tổng 2 cạnh a và c phải lớn hơn cạnh b");
        } else if (b + c <= a) {
            throw new IllegalTriangleException("Lỗi, tổng 2 cạnh b và c phải lớn hơn cạnh a");
        } else {
            System.out.println("OK, nhập độ dài 3 cạnh đúng.");
        }
    }
}
