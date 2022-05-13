package ss07_abstract_class_interface.bai_tap.resizeable_geometric;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Before resize: ");
        System.out.println(circle);

        circle.resize(10);

        System.out.println("After resize: ");
        System.out.println(circle);
    }
}
