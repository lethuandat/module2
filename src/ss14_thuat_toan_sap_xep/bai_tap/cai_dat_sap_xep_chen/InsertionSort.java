package ss14_thuat_toan_sap_xep.bai_tap.cai_dat_sap_xep_chen;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] array) {
        int pos;
        int x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (int value : list) {
            System.out.print(value + " ");
        }
    }
}
