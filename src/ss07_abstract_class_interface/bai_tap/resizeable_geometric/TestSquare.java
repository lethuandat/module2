package ss07_abstract_class_interface.bai_tap.resizeable_geometric;

public class TestSquare {
    public static void main(String[] args) {
        Square square = new Square(2.3);
        System.out.println("Before resize: ");
        System.out.println(square);

        square.resize(10);

        System.out.println("After resize: ");
        System.out.println(square);
    }
}
