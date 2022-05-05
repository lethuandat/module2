package bai_tap;

public class DisplayPrimeLessThan100 {
    public static void main(String[] args) {
        System.out.println("Prime numbers less than 100:");
        for (int i = 0; i < 100; i++) {
            if (i > 1) {
                int j = 2;
                boolean check = true;
                while (j <= Math.sqrt(i)) {
                    if (i % j == 0) {
                        check = false;
                        break;
                    }
                    j++;
                }
                if (check) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
