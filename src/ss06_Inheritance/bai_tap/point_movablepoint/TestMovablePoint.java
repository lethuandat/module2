package ss06_Inheritance.bai_tap.point_movablepoint;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(1.4f, 5.3f);
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(9.2f, 5.6f, 8.15f, 6.6f);
        System.out.println(movablePoint);

        movablePoint.move();
        System.out.println(movablePoint);
    }
}
