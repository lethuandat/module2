package ss10_dsa_list.bai_tap.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list = new MyList<>(5);

        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 3);
        list.add(4, 4);

        System.out.println("(1) " + list);


    }
}
