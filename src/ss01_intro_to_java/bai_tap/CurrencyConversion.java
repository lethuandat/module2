package ss01_intro_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD money: ");
        double usd = Double.parseDouble(scanner.nextLine());
        final double rate = 23000;
        double vnd = usd * rate;
        System.out.println(usd + " USD = " + vnd + "VNĐ");
    }
}
