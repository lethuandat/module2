package ss06_Inheritance.bai_tap.circle_cylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.0, "red");
        System.out.println(circle);
    }
}
