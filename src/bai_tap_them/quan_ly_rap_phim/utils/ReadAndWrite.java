package bai_tap_them.quan_ly_rap_phim.utils;

import bai_tap_them.quan_ly_rap_phim.comma.Comma;
import bai_tap_them.quan_ly_rap_phim.model.Cinema;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeTextFile(String pathFile, String data) {
        File file = new File(pathFile);
        try (FileWriter fileWriter = new FileWriter(file, false);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readTextFile(String pathFile) {
        File file = new File(pathFile);
        List<String[]> stringList = new ArrayList<>();
        String line;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] stringArr = line.split(Comma.COMMA);
                stringList.add(stringArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static List<Cinema> readCinemaFile() {
        List<Cinema> cinemaList = new ArrayList<>();
        List<String[]> list = readTextFile("src\\bai_tap_them\\quan_ly_rap_phim\\data\\cinema.csv");
        for (String[] item : list) {
            Cinema cinema = new Cinema(item[0], item[1], LocalDate.parse(item[2]), Integer.parseInt(item[3]));
            cinemaList.add(cinema);
        }
        return cinemaList;
    }
}
