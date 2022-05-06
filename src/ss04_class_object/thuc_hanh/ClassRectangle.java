package ss04_class_object.thuc_hanh;

import java.util.Scanner;

public class ClassRectangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the height: ");
        double height = Double.parseDouble(scanner.nextLine());

        Rectangle rectangle = new Rectangle(width, height);

        System.out.println("Your Rectangle: \n"+ rectangle.displayRectangle());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
    }

    public static class Rectangle {
        double width, height;

        public Rectangle() {
            }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return this.width * this.height;
        }

        public double getPerimeter() {
            return (this.width + this.height) * 2;
        }

        public String displayRectangle() {
            return "Rectangle{" + "width=" + width + ", height=" + height + "}";
        }
    }
}
