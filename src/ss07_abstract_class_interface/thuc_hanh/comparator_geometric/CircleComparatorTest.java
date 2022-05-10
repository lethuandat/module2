package ss07_abstract_class_interface.thuc_hanh.comparator_geometric;

import ss06_Inheritance.thuc_hanh.CircleTest;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        CircleTest.Circle[] circles = new CircleTest.Circle[3];
        circles[0] = new CircleTest.Circle(3.6);
        circles[1] = new CircleTest.Circle();
        circles[2] = new CircleTest.Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (CircleTest.Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (CircleTest.Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
