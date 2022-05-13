package ss07_abstract_class_interface.bai_tap.colorable_geometric;

public class TestSquare {
    public static void main(String[] args) {
        Square square = new Square(4);
        Square square1 = new Square();
        square1.setSide(6);

        System.out.println(square);
        square.howToColor();

        System.out.println(square1);
        square1.howToColor();
    }
}
