package bai_tap_them.quan_ly_tien_dien.utils;

import bai_tap_them.quan_ly_benh_an.comma.Comma;

import java.io.*;
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

//    public static void writeCustomerFile(List<Customer> lists) {
//        List<String> list = new ArrayList<>();
//        for (Customer e : lists) {
//            list.add(e.getInfo());
//        }
//        writeFile(list, "src/furama_resort/data/person/customer.csv");
//    }
//
//    public static void writeEmployeeFile(List<Employee> lists) {
//        List<String> list = new ArrayList<>();
//        for (Employee e : lists) {
//            list.add(e.getInfo());
//        }
//        writeFile(list, "src/furama_resort/data/person/employee.csv");
//    }
//
//    public static void readEmployeeFile(List<Employee> list) {
//        try {
//            FileReader fileReader = new FileReader("src/furama_resort/data/person/employee.csv");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                Employee employee = new Employee(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], Integer.parseInt(temp[9]));
//                list.add(employee);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void readCustomerFile(List<Customer> list) {
//        try {
//            FileReader fileReader = new FileReader("src/furama_resort/data/person/customer.csv");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                Customer customer = new Customer(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
//                list.add(customer);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
