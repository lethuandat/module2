package ss04_class_object.bai_tap.class_fan;

public class TestFan {
    public static void main(String[] args) {
        final byte SLOW = 1;
        final byte MEDIUM = 2;
        final byte FAST = 3;
        Fan fan1 = new Fan( FAST,true, 10, "yellow");
        Fan fan2 = new Fan( MEDIUM,false, 5, "blue");
        Fan fan3 = new Fan( SLOW,true, 15, "red");

        System.out.print("Fan 1: " + fan1);
        System.out.print("\nFan 2: " + fan2);
        System.out.print("\nFan 3: " + fan3);
    }
}
