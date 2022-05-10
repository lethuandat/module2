package ss05_access_modifier_static_method_static_property.bai_tap.circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3.0, "yellow");
        System.out.println("Hình tròn có bán kính: " + circle1.getRadius() + " và diện tích: " + circle1.getArea());
    }
}
