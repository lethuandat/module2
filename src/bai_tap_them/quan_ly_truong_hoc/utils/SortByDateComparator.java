package bai_tap_them.quan_ly_truong_hoc.utils;

import bai_tap_them.quan_ly_truong_hoc.model.Person;

import java.util.Comparator;

public class SortByDateComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getDate().compareTo(o2.getDate()) < 0) {
            return 1;
        } else if (o1.getDate().compareTo(o2.getDate()) > 0) {
            return -1;
        } else {
            if (o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
