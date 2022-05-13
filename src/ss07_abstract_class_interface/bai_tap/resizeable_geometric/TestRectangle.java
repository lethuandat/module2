package ss07_abstract_class_interface.bai_tap.resizeable_geometric;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5);
        System.out.println("Before resize: ");
        System.out.println(rectangle);

        rectangle.resize(10);

        System.out.println("After resize: ");
        System.out.println(rectangle);
    }
}
