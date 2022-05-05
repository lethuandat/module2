package bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD money: ");
        int usd = scanner.nextInt();
        final int rate = 23000;
        int vnd = usd * rate;
        System.out.println(usd + " USD = " + vnd + "VNĐ");
    }
}
