package bai_tap_them.quan_ly_rap_phim.service;

import bai_tap_them.quan_ly_rap_phim.exception.CinemaIdNotFoundException;
import bai_tap_them.quan_ly_rap_phim.model.Cinema;
import bai_tap_them.quan_ly_rap_phim.utils.ReadAndWrite;
import bai_tap_them.quan_ly_rap_phim.utils.RegexData;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaServiceImpl implements IService {
    public static final String REGEX_ID_CINEMA = "^CI-[1-9]{4}$";
    public static final String REGEX_POSITIVE_NUMBER = "[1-9][0-9]*";
    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    static Scanner scanner = new Scanner(System.in);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    List<Cinema> cinemaList = new ArrayList<>();

    @Override
    public void display() {
        cinemaList = ReadAndWrite.readCinemaFile();

        System.out.println("List cinema showtime:");
        for (Cinema cinema : cinemaList) {
            System.out.println(cinema);
        }
    }

    @Override
    public void add() {
        cinemaList = ReadAndWrite.readCinemaFile();

        boolean check;
        String idCinema;

        do {
            check = false;
            System.out.println("Input cinema id:");
            idCinema = RegexData.regexStr(scanner.nextLine(), REGEX_ID_CINEMA, "ID cinema formal is CI-XXXX. Input again!");
            for (Cinema cinema : cinemaList) {
                if (cinema.getIdCinema().equals(idCinema)) {
                    check = true;
                    System.out.println("Cinema ID has been already. Input again!");
                }
            }
        } while (check);

        System.out.println("Input name movie:");
        String name = scanner.nextLine();

        LocalDate date = inputDate();

        System.out.println("Input ticket quantity");
        int quantity = Integer.parseInt(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE_NUMBER, "Quantity must > 0. Input again"));

        Cinema cinema = new Cinema(idCinema, name, date, quantity);
        cinemaList.add(cinema);

        System.out.println("Add successful!");
        ReadAndWrite.writeCinemaFile();
    }

    public LocalDate inputDate() {
        System.out.println("Input day:");
        LocalDate date = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input format date incorrect. Input again"), formatter);
        LocalDate now;

        do {
            now = LocalDate.now();
            int current = Period.between(now, date).getDays();
            if (current > 0) {
                return date;
            } else {
                System.out.println("Date must > day now. Input again!");
                date = LocalDate.parse(bai_tap_them.quan_ly_nhan_vien_abc.utils.RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again!"), formatter);
            }
        } while (true);
    }

    @Override
    public void remove() {
        cinemaList = ReadAndWrite.readCinemaFile();

        System.out.println("Enter id cinema you want to remove:");
        String delIdCinema = scanner.nextLine();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < cinemaList.size(); i++) {
            if (cinemaList.get(i).getIdCinema().equals(delIdCinema)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Do you want to remove cinema ID: " + delIdCinema);
            System.out.println("Choose yes or no");
            String result = scanner.nextLine();

            switch (result) {
                case "yes":
                    cinemaList.remove(index);
                    System.out.println("Remove successful.");

                    ReadAndWrite.writeCinemaFile();
                    display();
                    break;
                case "no":
                    return;
                default:
                    System.out.println("Input wrong!");
            }
        } else {
            try {
                throw new CinemaIdNotFoundException("ID Cinema is not current!");
            } catch (CinemaIdNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }

        ReadAndWrite.writeCinemaFile();
    }
}
