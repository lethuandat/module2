package ss06_Inheritance.bai_tap.triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        System.out.println("Nhập chiều dài cạnh thứ nhất: ");
        double side1 = Double.parseDouble(input.nextLine());

        System.out.println("Nhập chiều dài cạnh thứ hai: ");
        double side2 = Double.parseDouble(input.nextLine());

        System.out.println("Nhập chiều dài cạnh thứ ba: ");
        double side3 = Double.parseDouble(input.nextLine());

        System.out.println("Nhập màu sắc cho tam giác: ");
        String color = input.nextLine();

        triangle = new Triangle(side1, side2, side3, color);
        System.out.println(triangle);
    }
}
