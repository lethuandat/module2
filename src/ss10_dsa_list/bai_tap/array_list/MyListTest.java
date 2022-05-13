package ss10_dsa_list.bai_tap.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(0, 1);
        myList.add(1, 2);
        myList.add(2, 3);
        myList.add(3, 4);
        myList.add(4, 5);
        System.out.println("List ban đầu: ");
        printList(myList.getElements());

        System.out.println("\nList sau khi xóa: ");
        myList.remove(2);
        printList(myList.getElements());
        System.out.println("\nList sau khi thêm: ");
        myList.add(2, 100);
        printList(myList.getElements());

    }

    public static void printList(Object[] objects) {
        for (Object item : objects) {
            if (item != null) {
                System.out.print(item + " ");
            }
        }
    }
}
