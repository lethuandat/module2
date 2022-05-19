package ss11_dsa_stack_queue.bai_tap.demerging_dung_queue;

import java.util.*;

public class DemergeQueue {
    public static void main(String[] args) {
        List<Personnel> personnelList = new ArrayList<>();
        personnelList.add(0, new Personnel("Lê Thị A", "Nữ", 1999));
        personnelList.add(1, new Personnel("Lê Văn B", "Nam", 1998));
        personnelList.add(2, new Personnel("Lê Thị C", "Nữ", 1996));
        personnelList.add(3, new Personnel("Lê Văn D", "Nam", 2000));
        personnelList.add(4, new Personnel("Lê Văn E", "Nam", 2001));
        personnelList.add(5, new Personnel("Lê Thị F", "Nữ", 1995));
        personnelList.add(6, new Personnel("Lê Thị G", "Nữ", 1993));

        Queue<Personnel> nuQueue = new LinkedList<>();
        Queue<Personnel> namQueue = new LinkedList<>();
        Collections.sort(personnelList);

        for (Personnel item : personnelList) {
            System.out.println(item);
        }

        for (Personnel personnel : personnelList) {
            if (personnel.getGender().equals("Nữ")) {
                nuQueue.add(personnel);
            } else {
                namQueue.add(personnel);
            }
        }
        System.out.println("Danh sách nữ/nam theo năm sinh:");
        while (!nuQueue.isEmpty()) {
            System.out.println(nuQueue.poll());
        }

        while (!namQueue.isEmpty()) {
            System.out.println(namQueue.poll());
        }
    }
}
