package ss15_exception_debug.bai_tap.lop_illegal_triangle;

import java.util.Scanner;

public class TriangleCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TriangleCheck triangleCheck = new TriangleCheck();

        System.out.println("Nhập độ dài 3 cạnh của tam giác: ");
        try {
            System.out.println("Nhập cạnh thứ nhất ");
            double edge1 = Double.parseDouble(input.nextLine());
            System.out.println("Nhập cạnh thứ 2 ");
            double edge2 = Double.parseDouble(input.nextLine());
            System.out.println("Nhập cạnh thứ 3 ");
            double edge3 = Double.parseDouble(input.nextLine());
            triangleCheck.checkTriangle(edge1, edge2, edge3);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a || a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Lỗi, nhập cạnh tam giác không đúng!");
        } else {
            System.out.println("OK, nhập độ dài 3 cạnh đúng.");
        }
    }
}
