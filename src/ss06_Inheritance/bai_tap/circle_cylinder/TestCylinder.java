package ss06_Inheritance.bai_tap.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(4.0, "violet", 3.0);
        System.out.println(cylinder);

        cylinder = new Cylinder(5.0, "green", 9.0);
        System.out.println(cylinder);
    }
}
