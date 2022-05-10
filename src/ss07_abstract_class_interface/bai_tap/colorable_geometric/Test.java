package ss07_abstract_class_interface.bai_tap.colorable_geometric;

public class Test {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() * 10 + 5);
        int y = (int) Math.floor(Math.random() * 5 + 1);

        Shape[] shapeArr = new Shape[4];
        shapeArr[0] = new Circle(x, "yellow", false);
        shapeArr[1] = new Rectangle(x, y, "infinity", true);
        shapeArr[2] = new Square(x, "melinda", true);
        shapeArr[3] = new Square(x, "pink", true);

        for (Shape item : shapeArr){
            System.out.println(item);
        }

        for (Shape item : shapeArr) {
            item.howToColor();
        }
        System.out.println("\n");
        Shape.printShape(shapeArr);
    }
}
