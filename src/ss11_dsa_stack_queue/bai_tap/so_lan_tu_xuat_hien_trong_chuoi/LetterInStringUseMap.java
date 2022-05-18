package ss11_dsa_stack_queue.bai_tap.so_lan_tu_xuat_hien_trong_chuoi;

import java.util.Scanner;
import java.util.TreeMap;

public class LetterInStringUseMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = input.nextLine();

        TreeMap<String, Integer> countLetterMap = new TreeMap<>();

        int value = 0;
        String[] arrStr = str.toUpperCase().split(" ");

        for (String item : arrStr) {
            if (countLetterMap.containsKey(item)) {
                value = value + 1;
                countLetterMap.put(item, value);
            } else {
                value = 1;
                countLetterMap.put(item, value);
            }
        }

        System.out.println(countLetterMap);
    }
}
