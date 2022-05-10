package ss07_abstract_class_interface.bai_tap.resizeable_geometric;

public class Test {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() * 20 + 10);
        int y = (int) Math.floor(Math.random() * 10 + 5);
        Shape[] shapeArr = new Shape[3];
        shapeArr[0] = new Circle(x, "yellow", false);
        shapeArr[1] = new Rectangle(x, y, "infinity", true);
        shapeArr[2] = new Square(x, "melinda", true);

        for (Shape value : shapeArr){
            System.out.println(value);
        }

        for (Shape value : shapeArr) {
            value.resize(Math.random() * 100 + 1);
        }
        System.out.println("\n");
        Shape.printShape(shapeArr);
    }
}
