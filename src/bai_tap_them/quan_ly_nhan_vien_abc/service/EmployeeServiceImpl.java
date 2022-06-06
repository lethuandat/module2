package bai_tap_them.quan_ly_nhan_vien_abc.service;

import bai_tap_them.quan_ly_nhan_vien_abc.exception.NotFoundEmployeeException;
import bai_tap_them.quan_ly_nhan_vien_abc.model.Employee;
import bai_tap_them.quan_ly_nhan_vien_abc.model.ManagerEmployee;
import bai_tap_them.quan_ly_nhan_vien_abc.model.ProduceEmployee;
import bai_tap_them.quan_ly_nhan_vien_abc.utils.ReadAndWrite;
import bai_tap_them.quan_ly_nhan_vien_abc.utils.RegexData;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IService {
    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String REGEX_MANAGER = "^NVQL-\\d{3}$";
    public static final String REGEX_PRODUCE = "^NVSX-\\d{3}$";
    public static final String REGEX_POSITIVE_NUMBER = "[1-9][0-9]*";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    List<Employee> employeeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        employeeList = ReadAndWrite.readEmployee();

        System.out.println("List of employee: ");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void add() {
        String choose;
        do {
            System.out.println("Are you want to add :");
            System.out.println("1. Add new manager");
            System.out.println("2. Add new produce");
            System.out.println("3. Back to menu");
            System.out.println("Enter choose:");

            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addManager();
                    break;
                case "2":
                    addProduce();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Your choose is incorrect! Choose again!");
            }
        } while (true);
    }

    public LocalDate inputDate() {
        System.out.println("Enter employee date: ");
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

    public void addManager() {
        employeeList = ReadAndWrite.readEmployee();
        int id = increaseID();

        System.out.println("Enter employee id: ");
        String idEmployee = RegexData.regexStr(scanner.nextLine(), REGEX_MANAGER, "ID manager: NVQL-XXX. Input again!");

        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();

        LocalDate date = inputDate();

        System.out.println("Enter employee address: ");
        String address = scanner.nextLine();

        System.out.println("Enter employee base salary: ");
        double baseSalary = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE_NUMBER, "Base salary must > 0. Input again!"));

        System.out.println("Enter employee factor: ");
        double factor = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE_NUMBER, "Factor must > 0. Input again!"));

        ManagerEmployee managerEmployee = new ManagerEmployee(id, idEmployee, name, date, address, baseSalary, factor);
        employeeList.add(managerEmployee);

        System.out.println("Add manager employee successful.");
        ReadAndWrite.writeEmployee();
    }

    public int increaseID() {
        employeeList = ReadAndWrite.readEmployee();
        int id;
        int max = 0;
        if (employeeList.size() == 0) {
            id = 1;
        } else {
            for (Employee employee : employeeList) {
                if (max < employee.getId()) {
                    max = employee.getId();
                }
            }
            id = max + 1;
        }
        return id;
    }

    public void addProduce() {
        employeeList = ReadAndWrite.readEmployee();
        int id = increaseID();

        System.out.println("Enter employee id: ");
        String idEmployee = RegexData.regexStr(scanner.nextLine(), REGEX_PRODUCE, "ID produce: NVSX-XXX. Input again!");

        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();

        LocalDate date = inputDate();

        System.out.println("Enter employee address: ");
        String address = scanner.nextLine();

        System.out.println("Enter product quantity ");
        int quantity = Integer.parseInt(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE_NUMBER, "Quantity must > 0. Input again!"));

        System.out.println("Enter product price: ");
        double price = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_POSITIVE_NUMBER, "Price must > 0. Input again!"));

        ProduceEmployee produceEmployee = new ProduceEmployee(id, idEmployee, name, date, address, quantity, price);
        employeeList.add(produceEmployee);

        System.out.println("Add manager employee successful.");
        ReadAndWrite.writeEmployee();
    }

    @Override
    public void remove() {
        employeeList = ReadAndWrite.readEmployee();

        System.out.println("Enter id employee you want to remove:");
        String delIdEmployee = scanner.nextLine();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdEmployee().equals(delIdEmployee)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Do you want to remove employee ID: " + delIdEmployee);
            System.out.println("Choose yes or no");
            String result = scanner.nextLine();

            switch (result) {
                case "yes":
                    employeeList.remove(index);
                    System.out.println("Remove successful.");

                    ReadAndWrite.writeEmployee();
                    display();
                    break;
                case "no":
                    return;
                default:
                    System.out.println("Input wrong!");
            }
        } else {
            try {
                throw new NotFoundEmployeeException("ID employee is not current!");
            } catch (NotFoundEmployeeException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void find() {
        employeeList = ReadAndWrite.readEmployee();

        System.out.println("Enter anything you want to find:");
        String findStr = scanner.nextLine();
        boolean check = false;

        for (Employee employee : employeeList) {
            if (employee.getIdEmployee().contains(findStr) || employee.getName().contains(findStr) || employee.getAddress().contains(findStr)) {
                check = true;
                System.out.println(employee);
            }
        }

        if (!check) {
            System.out.println("Find no result!");
        }
    }
}
