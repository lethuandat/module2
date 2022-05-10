package ss04_class_object.bai_tap.class_quadratic_equation;

import java.util.Scanner;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a = ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập b = ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập c = ");
        double c = Double.parseDouble(scanner.nextLine());

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("Phương trình bậc 2: \n"+ quadraticEquation.display());

        double r1 = quadraticEquation.getRoot1();
        double r2 = quadraticEquation.getRoot2();
        double delta = quadraticEquation.getDiscriminant();
        if (delta > 0) {
            System.out.println("Phương trình 2 có nghiệm là: x1 = " + r1 + ", x2 = " + r2);
        } else if (delta == 0) {
            System.out.println("Phương trình có nghiệm kép x1 = x2 = " + r1);
        } else {
            System.out.println("Phương trình vô nghiệm");
        }

    }
}
