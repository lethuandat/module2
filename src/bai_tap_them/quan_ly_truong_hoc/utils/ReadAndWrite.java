package bai_tap_them.quan_ly_truong_hoc.utils;

import bai_tap_them.quan_ly_nhan_vien_abc.comma.Comma;
import bai_tap_them.quan_ly_truong_hoc.model.Student;
import bai_tap_them.quan_ly_truong_hoc.model.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    static List<String[]> list = new ArrayList<>();
    static List<Student> studentList = new ArrayList<>();
    static List<Teacher> teacherList = new ArrayList<>();

    public static List<Student> readStudent() {
        list = readTextFile("src\\bai_tap_them\\quan_ly_truong_hoc\\data\\student.csv");
        studentList.clear();

        for (String[] item : list) {
            Student student = new Student(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    LocalDate.parse(item[3]),
                    item[4],
                    item[5],
                    Double.parseDouble(item[6]));
            studentList.add(student);
        }

        return studentList;
    }

    public static void writeStudent() {
        StringBuilder line = new StringBuilder();
        for (Student student : studentList) {
            line.append(student.getInfo()).append("\n");
        }

        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_truong_hoc\\data\\student.csv", line.toString());
    }

    public static void writeTeacher() {
        StringBuilder line = new StringBuilder();
        for (Teacher teacher : teacherList) {
            line.append(teacher.getInfo()).append("\n");
        }

        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_truong_hoc\\data\\teacher.csv", line.toString());
    }

    public static List<Teacher> readTeacher() {
        list = readTextFile("src\\bai_tap_them\\quan_ly_truong_hoc\\data\\teacher.csv");
        teacherList.clear();

        for (String[] item : list) {
            Teacher teacher = new Teacher(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    LocalDate.parse(item[3]),
                    item[4],
                    item[5],
                    Double.parseDouble(item[6]),
                    Integer.parseInt(item[7]));
            teacherList.add(teacher);
        }

        return teacherList;
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
