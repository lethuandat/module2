package ss04_class_object.bai_tap.class_quadratic_equation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return getB() * getB() - 4 * getA() * getC();
    }

    public double getRoot1() {
        return (-getB() + Math.pow(this.getDiscriminant(), 0.5)) / (2 * getA());
    }

    public double getRoot2() {
        return (-getB() - Math.pow(this.getDiscriminant(), 0.5)) / (2 * getA());
    }

    @Override
    public String toString() {
        return getA() + "x2 + " + getB() + "x + " + getC() + " = 0";
    }

}
