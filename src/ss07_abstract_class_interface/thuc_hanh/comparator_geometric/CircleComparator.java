package ss07_abstract_class_interface.thuc_hanh.comparator_geometric;

import ss06_Inheritance.thuc_hanh.CircleTest;

import java.util.Comparator;

public class CircleComparator implements Comparator<CircleTest.Circle> {

    @Override
    public int compare(CircleTest.Circle c1, CircleTest.Circle c2) {
        if (c1.getRadius() > c2.getRadius()) {
            return 1;
        } else if (c1.getRadius() < c2.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
