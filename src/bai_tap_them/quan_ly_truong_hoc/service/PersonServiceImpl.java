package bai_tap_them.quan_ly_truong_hoc.service;

import bai_tap_them.quan_ly_truong_hoc.exception.IdNotFoundException;
import bai_tap_them.quan_ly_truong_hoc.exception.MyException;
import bai_tap_them.quan_ly_truong_hoc.model.Person;
import bai_tap_them.quan_ly_truong_hoc.model.Student;
import bai_tap_them.quan_ly_truong_hoc.model.Teacher;
import bai_tap_them.quan_ly_truong_hoc.utils.ReadAndWrite;
import bai_tap_them.quan_ly_truong_hoc.utils.RegexData;
import bai_tap_them.quan_ly_truong_hoc.utils.SortByDateComparator;
import bai_tap_them.quan_ly_truong_hoc.utils.SortByNameComparator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements IService {
    public static final String REGEX_STUDENT_ID = "\\d{8}";
    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    List<Student> studentList = new ArrayList<>();
    List<Teacher> teacherList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println("List person:");

        studentList = ReadAndWrite.readStudent();

        for (Student student : studentList) {
            System.out.println(student);
        }

        teacherList = ReadAndWrite.readTeacher();

        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public int increaseIdStudent() {
        studentList = ReadAndWrite.readStudent();
        int id;
        int max = 0;
        if (studentList.size() == 0) {
            id = 1;
        } else {
            for (Student student : studentList) {
                if (max < student.getId()) {
                    max = student.getId();
                }
            }
            id = max + 1;
        }
        return id;
    }

    public int increaseIdTeacher() {
        teacherList = ReadAndWrite.readTeacher();
        int id;
        int max = 0;
        if (teacherList.size() == 0) {
            id = 1;
        } else {
            for (Teacher teacher : teacherList) {
                if (max < teacher.getId()) {
                    max = teacher.getId();
                }
            }
            id = max + 1;
        }
        return id;
    }

    @Override
    public void add() {
        String choose;

        do {
            System.out.println("1. Add new teacher");
            System.out.println("2. Add new student");
            System.out.println("3. Back to menu");
            System.out.println("Enter your choose");

            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    addTeacher();
                    break;
                case "2":
                    addStudent();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Choose incorrect. Try again!");
            }
        } while (true);
    }

    public void addTeacher() {
        teacherList = ReadAndWrite.readTeacher();

        int id = increaseIdTeacher();

        System.out.println("Enter teacher name:");
        String name = MyException.checkStr();

        System.out.println("Enter gender:");
        String gender = chooseGender();

        LocalDate date = inputDate();

        System.out.println("Enter address:");
        String address = MyException.checkStr();

        System.out.println("Enter class:");
        String classTeacher = MyException.checkStr();

        System.out.println("Enter salary / hour");
        double unitSalary = MyException.checkParseDouble();

        System.out.println("Enter number of hour teach:");
        Integer numbTeach = MyException.checkParseInt();

        Teacher teacher = new Teacher(id, name, gender, date, address, classTeacher, unitSalary, numbTeach);
        teacherList.add(teacher);

        System.out.println("Add teacher successful!");
        ReadAndWrite.writeTeacher();
    }

    public String chooseGender() {
        String choose;

        do {
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. LGBT");
            System.out.println("Enter your choose");

            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    return "Male";
                case "2":
                    return "Female";
                case "3":
                    return "LGBT";
                default:
                    System.out.println("Choose incorrect. Try again!");
            }
        } while (true);
    }

    public LocalDate inputDate() {
        System.out.println("Enter date: ");
        LocalDate date = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again!"), formatter);
        LocalDate now;

        do {
            now = LocalDate.now();
            int current = Period.between(date, now).getYears();
            if (current >= 18) {
                return date;
            } else {
                System.out.println("Date must >= 18 years old! Input again!");
                date = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input date wrong. Input again!"), formatter);
            }
        } while (true);
    }

    public void addStudent() {
        studentList = ReadAndWrite.readStudent();

        int id = increaseIdStudent();

        System.out.println("Enter student name:");
        String name = MyException.checkStr();

        System.out.println("Enter gender:");
        String gender = chooseGender();

        LocalDate date = inputDate();

        System.out.println("Enter address:");
        String address = MyException.checkStr();

        String studentID = checkIdStudent();

        System.out.println("Enter point:");
        double point = getPoint();

        Student student = new Student(id, name, gender, date, address, studentID, point);
        studentList.add(student);

        System.out.println("Add student successful!");
        ReadAndWrite.writeStudent();
    }

    public double getPoint() {
        double point;
        boolean check = true;
        do {
            point = MyException.checkPoint();
            if (point >= 0 && point <= 10) {
                check = false;
            } else {
                System.out.println("Point must <= 10 and >=0, try again!");
            }
        } while (check);
        return point;
    }

    public String checkIdStudent() {
        boolean check;
        String studentID;

        do {
            check = false;
            System.out.println("Enter student id: ");
            studentID = RegexData.regexStr(scanner.nextLine(), REGEX_STUDENT_ID, "Student id has XXXXXXXX, try again!");
            for (Student item : studentList) {
                if (item.getIdStudent().equals(studentID)) {
                    check = true;
                    System.out.println("Student id has been already, try again!");
                }
            }
        } while (check);
        return studentID;
    }

    @Override
    public void remove() {
        String choose;

        do {
            System.out.println("1. Remove teacher");
            System.out.println("2. Remove student");
            System.out.println("3. Back to menu");
            System.out.println("Enter your choose");

            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    removeTeacher();
                    break;
                case "2":
                    removeStudent();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Choose incorrect. Try again!");
            }
        } while (true);
    }

    public void removeTeacher() {
        teacherList = ReadAndWrite.readTeacher();

        System.out.println("Enter id teacher you want to remove:");
        Integer idTecher = MyException.checkParseInt();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId().equals(idTecher)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Do you want to remove teacher ID: " + idTecher);
            System.out.println("Choose yes or no");
            String result = scanner.nextLine();

            switch (result) {
                case "yes":
                    teacherList.remove(index);
                    System.out.println("Remove successful.");

                    ReadAndWrite.writeTeacher();
                    System.out.println("List teacher:");

                    for (Teacher teacher : teacherList) {
                        System.out.println(teacher);
                    }
                    break;
                case "no":
                    return;
                default:
                    System.out.println("Input wrong!");
            }
        } else {
            try {
                throw new IdNotFoundException("ID teacher is not current!");
            } catch (IdNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void removeStudent() {
        studentList = ReadAndWrite.readStudent();

        System.out.println("Enter id student you want to remove:");
        Integer idStudent = MyException.checkParseInt();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(idStudent)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Do you want to remove student ID: " + idStudent);
            System.out.println("Choose yes or no");
            String result = scanner.nextLine();

            switch (result) {
                case "yes":
                    studentList.remove(index);
                    System.out.println("Remove successful.");

                    ReadAndWrite.writeStudent();
                    System.out.println("List student:");

                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    break;
                case "no":
                    return;
                default:
                    System.out.println("Input wrong!");
            }
        } else {
            try {
                throw new IdNotFoundException("ID student is not current!");
            } catch (IdNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void sort() {
        studentList = ReadAndWrite.readStudent();

        List<Person> personList = new ArrayList<>(studentList);

        teacherList = ReadAndWrite.readTeacher();

        personList.addAll(teacherList);

        String choose;
        do {
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by date");
            System.out.println("3. Back to menu");
            System.out.println("Enter your choose:");
            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    personList.sort(new SortByNameComparator());
                    for (Person person : personList) {
                        System.out.println(person);
                    }
                    break;
                case "2":
                    personList.sort(new SortByDateComparator());
                    for (Person person : personList) {
                        System.out.println(person);
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Your choose incorrect, try again!");
            }
        } while (true);
    }

    @Override
    public void edit() {
        String choose;

        do {
            System.out.println("1. Edit teacher");
            System.out.println("2. Edit student");
            System.out.println("3. Back to menu");
            System.out.println("Enter your choose");

            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    editTeacher();
                    break;
                case "2":
                    editStudent();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Choose incorrect. Try again!");
            }
        } while (true);
    }

    public void editTeacher() {
        teacherList = ReadAndWrite.readTeacher();

        System.out.println("Enter ID teacher you want edit:");
        Integer id = MyException.checkParseInt();

        int index = 0;
        boolean check = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId().equals(id)) {
                index = i;
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println("Enter name:");
            String name = MyException.checkStr();

            System.out.println("Enter gender:");
            String gender = chooseGender();

            LocalDate date = inputDate();

            System.out.println("Enter address:");
            String address = MyException.checkStr();

            System.out.println("Enter class:");
            String classTeacher = MyException.checkStr();

            System.out.println("Enter salary / hour");
            double unitSalary = MyException.checkParseDouble();

            System.out.println("Enter number of hour teach:");
            Integer numbTeach = MyException.checkParseInt();

            teacherList.get(index).setName(name);
            teacherList.get(index).setGender(gender);
            teacherList.get(index).setDate(date);
            teacherList.get(index).setAddress(address);
            teacherList.get(index).setClassName(classTeacher);
            teacherList.get(index).setUnitSalary(unitSalary);
            teacherList.get(index).setHourTeach(numbTeach);

            System.out.println("Edit teacher successful!");
            ReadAndWrite.writeTeacher();
        } else {
            System.out.println("ID incorrect!");
        }
    }

    public void editStudent() {
        studentList = ReadAndWrite.readStudent();

        System.out.println("Enter ID student you want edit:");
        Integer id = MyException.checkParseInt();

        int index = 0;
        boolean check = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                index = i;
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println("Enter name:");
            String name = MyException.checkStr();

            System.out.println("Enter gender:");
            String gender = chooseGender();

            LocalDate date = inputDate();

            System.out.println("Enter address:");
            String address = MyException.checkStr();

            String studentID = checkIdStudent();

            System.out.println("Enter point:");
            double point = getPoint();

            studentList.get(index).setName(name);
            studentList.get(index).setGender(gender);
            studentList.get(index).setDate(date);
            studentList.get(index).setAddress(address);
            studentList.get(index).setIdStudent(studentID);
            studentList.get(index).setPoint(point);

            System.out.println("Edit student successful!");
            ReadAndWrite.writeStudent();
        } else {
            System.out.println("ID incorrect!");
        }
    }
}
