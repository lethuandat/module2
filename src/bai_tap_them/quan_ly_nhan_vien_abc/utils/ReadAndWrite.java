package bai_tap_them.quan_ly_nhan_vien_abc.utils;

import bai_tap_them.quan_ly_nhan_vien_abc.comma.Comma;
import bai_tap_them.quan_ly_nhan_vien_abc.model.Employee;
import bai_tap_them.quan_ly_nhan_vien_abc.model.ManagerEmployee;
import bai_tap_them.quan_ly_nhan_vien_abc.model.ProduceEmployee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    static List<String[]> list = new ArrayList<>();
    static List<Employee> employeeList = new ArrayList<>();

    public static List<Employee> readEmployee() {
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_nhan_vien_abc\\data\\employee.csv");
        employeeList.clear();
        for (String[] strings : list) {
            if (strings[1].contains("NVSX")) {
                ProduceEmployee produceEmployee = new ProduceEmployee(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        LocalDate.parse(strings[3]),
                        strings[4],
                        Integer.parseInt(strings[5]),
                        Double.parseDouble(strings[6]));
                employeeList.add(produceEmployee);
            } else {
                ManagerEmployee managerEmployee = new ManagerEmployee(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        LocalDate.parse(strings[3]),
                        strings[4],
                        Double.parseDouble(strings[5]),
                        Double.parseDouble(strings[6]));
                employeeList.add(managerEmployee);
            }
        }
        return employeeList;
    }

    public static void writeEmployee() {
        StringBuilder line = new StringBuilder();
        for (Employee employee : employeeList) {
            line.append(employee.getInfo()).append("\n");
        }

        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_nhan_vien_abc\\data\\employee.csv", line.toString());
    }

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
}
