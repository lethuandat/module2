package ss10_dsa_list.bai_tap.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> listString = new MyLinkedList<>("Thủy");


        listString.add(1, "Mai");
        listString.add(2, "Hoa");
        listString.add(3, "Linh");
        listString.add(4, "Long");
        listString.printList();
        System.out.println("Mai ở vị trí " + listString.indexOf("Mai"));

        //Kiểm tra abc có trong list không
        System.out.println(listString.contains("abc") ? "abc có trong list" : " abc không có trong list");

        System.out.println("----------------");
        listString.addFirst("Quân");
        listString.addLast("Hoàng");
        listString.printList();

        System.out.println("Lấy ra phần tử ở vị trí 2");
        System.out.println(listString.get(2));

        System.out.println("Xóa vị trí số 3");
        listString.remove(3);
        listString.printList();

        System.out.println("Xóa \"Linh\"");
        listString.remove("Linh");
        listString.printList();
    }
}
