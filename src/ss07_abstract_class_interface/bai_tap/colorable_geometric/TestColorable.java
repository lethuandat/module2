package ss07_abstract_class_interface.bai_tap.colorable_geometric;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapeArr = new Shape[4];
        shapeArr[0] = new Circle(5, "yellow", false);
        shapeArr[1] = new Rectangle(10, 5, "infinity", true);
        shapeArr[2] = new Square(4, "melinda", true);
        shapeArr[3] = new Square(6, "pink", true);

        System.out.println("List shape: ");
        for (Shape item : shapeArr) {
            if (item instanceof Colorable) {
                System.out.print(item + " ---> ");
                ((Colorable) item).howToColor();
            } else {
                System.out.println(item);
            }
        }
    }
}
