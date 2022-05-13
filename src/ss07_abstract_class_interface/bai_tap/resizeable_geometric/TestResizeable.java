package ss07_abstract_class_interface.bai_tap.resizeable_geometric;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shapeArr = new Shape[3];
        shapeArr[0] = new Circle(10, "yellow", false);
        shapeArr[1] = new Rectangle(20, 10, "infinity", true);
        shapeArr[2] = new Square(10, "melinda", true);

        System.out.println("List shape before: ");
        for (Shape value : shapeArr) {
            System.out.println(value);
        }

        System.out.println("List shape after: ");
        for (Shape value : shapeArr) {
            ((Resizeable) value).resize(Math.random() * 99 + 1);
            System.out.println(value);
        }
    }
}
