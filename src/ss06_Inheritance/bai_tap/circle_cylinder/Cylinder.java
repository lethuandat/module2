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
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + height);
    }

    public double getVolume() {
        return super.getArea() * getHeight();
    }

    @Override
    public String toString() {
        return "Hình trụ có bán kính là " + getRadius() +
                ", có màu là " + getColor() +
                ", có chiều cao là " + getHeight() +
                ", có diện tích là " + getArea() +
                " và có thể tích là " + getVolume();
    }
}
