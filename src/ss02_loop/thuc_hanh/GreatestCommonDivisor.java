package thuc_hanh;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        int number1 = scanner.nextInt();
        System.out.println("Enter b: ");
        int number2 = scanner.nextInt();

        if (number1 == 0 || number2 == 0) {
            System.out.println("No greatest common factor");
        } else {
            while (number1 != number2) {
                if (number1 > number2) {
                    number1 = number1 - number2;
                } else {
                    number2 = number2 - number1;
                }
            }
            System.out.println("Greatest common factor: " + number1);
        }
    }
}
