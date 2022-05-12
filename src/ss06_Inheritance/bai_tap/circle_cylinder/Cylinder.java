package ss06_Inheritance.bai_tap.circle_cylinder;

public class Cylinder extends Circle {
    private double height = 3.0;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getArea() * 2 + 2 * Math.PI * super.getRadius() * height;
    }

    public double getVolume() {
        return super.getArea() * getHeight();
    }

    @Override
    public String toString() {
        return "Hình trụ có bán kính là " + super.getRadius() +
                ", có màu là " + super.getColor() +
                ", có chiều cao là " + height +
                ", có diện tích là " + this.getArea() +
                " và có thể tích là " + getVolume();
    }
}
