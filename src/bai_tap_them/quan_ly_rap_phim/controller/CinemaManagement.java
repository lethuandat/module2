package bai_tap_them.quan_ly_rap_phim.controller;

import bai_tap_them.quan_ly_rap_phim.service.CinemaServiceImpl;
import bai_tap_them.quan_ly_rap_phim.service.IService;

import java.util.Scanner;

public class CinemaManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        String chosen;
        IService service = new CinemaServiceImpl();
        do {
            System.out.println("--ABC CINEMA--");
            System.out.println("Chosen function: ");
            System.out.println("1. List all showtime");
            System.out.println("2. Add showtime");
            System.out.println("3. Remove showtime");
            chosen = scanner.nextLine();

            switch (chosen) {
                case "1":
                    service.display();
                    break;
                case "2":
                    service.add();
                    break;
                case "3":
                    service.remove();
                    break;
                default:
                    System.out.println("Your choose is incorrect! Please input again:");
            }
        } while (true);
    }
}
