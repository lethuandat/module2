package ss10_dsa_list.bai_tap.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>(20);

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        System.out.println("List ban đầu: ");
        printList(myList.getElements());
        System.out.println("Số lượng phần tử trong list: " + myList.getSize());

        System.out.println("\nList sau khi xóa ở vị trí xác định: ");
        myList.remove(2);
        printList(myList.getElements());

        System.out.println("\nList sau khi thêm ở vị trí xác định: ");
        myList.add(2, 100);
        printList(myList.getElements());

        System.out.println("\nPhần tử thứ 1 là " + myList.get(1));
        System.out.println("Phần tử thứ 4 là " + myList.get(4));
        System.out.println("Phần tử thứ 8 là " + myList.get(8));

        System.out.println("Vị trí của giá trị 4 là " + myList.indexOf(4));
        System.out.println("Vị trí của giá trị 2 là " + myList.indexOf(2));
        System.out.println("Vị trí của giá trị 8 là " + myList.indexOf(8));
    }

    public static void printList(Object[] objects) {
        for (Object item : objects) {
            if (item != null) {
                System.out.print(item + " ");
            }
        }
    }
}
