package ss04_class_object.bai_tap;

import java.util.Scanner;

public class ClassQuadraticEquation {
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

    public static class QuadraticEquation {
        private double _a, _b, _c;

        public double getA() {
            return _a;
        }

        public void setA(double _a) {
            this._a = _a;
        }

        public double getB() {
            return _b;
        }

        public void setB(double _b) {
            this._b = _b;
        }

        public double getC() {
            return _c;
        }

        public void setC(double _c) {
            this._c = _c;
        }

        public QuadraticEquation() {
        }

        public QuadraticEquation(double a, double b, double c) {
             this._a = a;
             this._b = b;
             this._c = c;
        }

        public double getDiscriminant() {
             return this._b * this._b - 4 * this._a * this._c;
        }

        public double getRoot1() {
            return (-this._b + Math.pow(this.getDiscriminant(), 0.5)) / (2 * this._a);
        }

        public double getRoot2() {
            return (-this._b - Math.pow(this.getDiscriminant(), 0.5)) / (2 * this._a);
        }

        public String display() {
            return this._a + "x2 + " + this._b + "x + " + this._c + " = 0";
        }
    }
}
