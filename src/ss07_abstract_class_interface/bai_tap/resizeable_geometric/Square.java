package ss07_abstract_class_interface.bai_tap.resizeable_geometric;

public class Square extends Rectangle implements Resizeable {
    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        this.side = side;
        color = super.getColor();
        filled = super.isFilled();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + getSide()
                + ", area = " +
                + this.getArea()
                + ", color is " + super.getColor()
                + ", filled is " + super.isFilled();
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() * percent / 100 + getSide());
    }
}
