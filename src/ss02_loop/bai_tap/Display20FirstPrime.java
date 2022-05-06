package ss02_loop.bai_tap;

public class Display20FirstPrime {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        System.out.println("20 first prime numbers: ");
        while (count < 20) {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.print(number + " ");
                count++;
            }
            number++;
        }
    }
}
