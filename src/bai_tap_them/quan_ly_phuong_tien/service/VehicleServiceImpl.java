package bai_tap_them.quan_ly_phuong_tien.service;

import bai_tap_them.quan_ly_phuong_tien.exception.MyException;
import bai_tap_them.quan_ly_phuong_tien.model.Car;
import bai_tap_them.quan_ly_phuong_tien.model.Motorbike;
import bai_tap_them.quan_ly_phuong_tien.model.Truck;
import bai_tap_them.quan_ly_phuong_tien.model.Vehicle;
import bai_tap_them.quan_ly_phuong_tien.utils.ReadAndWrite;
import bai_tap_them.quan_ly_phuong_tien.utils.RegexData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VehicleServiceImpl implements IService {
    Scanner input = new Scanner(System.in);
    List<String[]> list = new ArrayList<>();
    List<Vehicle> vehicleList = new ArrayList<>();

    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String REGEX_LICENSE_CAR = "^[1-9]{2}A-[0-9]{2}[.][0-9]{3}$";
    public static final String REGEX_LICENSE_TRUCK = "^[1-9]{2}B-[0-9]{2}[.][0-9]{3}$";
    public static final String REGEX_LICENSE_MOTORBIKE = "^[1-9]{2}C-[0-9]{2}[.][0-9]{3}$";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void add() {
        do {
            System.out.println("Bạn muốn thêm loại xe gì: ");
            System.out.println("1. Xe ô tô");
            System.out.println("2. Xe tải");
            System.out.println("3. Xe máy");
            System.out.println("4. Trở về");
            System.out.println("Mời bạn chọn");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    addCar();
                    break;
                case "2":
                    addTruck();
                    break;
                case "3":
                    addMotorbike();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Nhập không đúng, mời nhập lại:");
            }
        } while (true);
    }

    public void addCar() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv");
        vehicleList.clear();

        for (String[] strings : list) {
            if (strings[0].contains("A")) {
                Car car = new Car(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Integer.parseInt(strings[4]),
                        strings[5]);
                vehicleList.add(car);
            } else if (strings[0].contains("B")) {
                Truck truck = new Truck(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(truck);
            } else {
                Motorbike motorbike = new Motorbike(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(motorbike);
            }
        }

        System.out.println("Nhập biển kiểm soát:");
        String license = RegexData.regexStr(input.nextLine(), REGEX_LICENSE_CAR, "Nhập sai, biển số xe ô tô có dạng: XXA-XX.XXX");

        System.out.println("Nhập tên hãng sản xuất:");
        String production = chooseProduction();

        System.out.println("Nhập năm sản xuất:");
        LocalDate year = LocalDate.parse(RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai ngày tháng, nhập lại:"), formatter);

        System.out.println("Nhập chủ sở hữu:");
        String owner = input.nextLine();

        System.out.println("Nhập số chỗ ngồi:");
        Integer seat = MyException.checkParseInt();

        System.out.println("Nhập kiểu xe:");
        String type = chooseType();

        Car car = new Car(license, production, year, owner, seat, type);
        vehicleList.add(car);

        String line = "";
        for (Vehicle vehicle : vehicleList) {
            line += vehicle.getInfo() + "\n";
        }

        System.out.println("Thêm thành công!");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv", line);
    }

    public String chooseType() {
        do {
            System.out.println("1. Du lịch");
            System.out.println("2. Xe khách");
            String choose = input.nextLine();

            switch (choose) {
                case "1":
                    return "Du lịch";
                case "2":
                    return "Xe khách";
                default:
                    System.out.println("Chọn sai, chọn lại:");
                    chooseType();
            }
        } while (true);
    }

    public void addMotorbike() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv");
        vehicleList.clear();

        for (String[] strings : list) {
            if (strings[0].contains("A")) {
                Car car = new Car(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Integer.parseInt(strings[4]),
                        strings[5]);
                vehicleList.add(car);
            } else if (strings[0].contains("B")) {
                Truck truck = new Truck(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(truck);
            } else {
                Motorbike motorbike = new Motorbike(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(motorbike);
            }
        }

        System.out.println("Nhập biển kiểm soát:");
        String license = RegexData.regexStr(input.nextLine(), REGEX_LICENSE_MOTORBIKE, "Nhập sai, biển số xe máy có dạng: XXC-XX.XXX");

        System.out.println("Nhập tên hãng sản xuất:");
        String production = chooseProduction();

        System.out.println("Nhập năm sản xuất:");
        LocalDate year = LocalDate.parse(RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai ngày tháng, nhập lại:"), formatter);

        System.out.println("Nhập chủ sở hữu:");
        String owner = input.nextLine();

        System.out.println("Nhập công suất:");
        Double wattage = MyException.checkParseDouble();

        Motorbike motorbike = new Motorbike(license, production, year, owner, wattage);
        vehicleList.add(motorbike);

        String line = "";
        for (Vehicle vehicle : vehicleList) {
            line += vehicle.getInfo() + "\n";
        }

        System.out.println("Thêm thành công!");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv", line);
    }

    public void addTruck() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv");
        vehicleList.clear();

        for (String[] strings : list) {
            if (strings[0].contains("A")) {
                Car car = new Car(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Integer.parseInt(strings[4]),
                        strings[5]);
                vehicleList.add(car);
            } else if (strings[0].contains("B")) {
                Truck truck = new Truck(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(truck);
            } else {
                Motorbike motorbike = new Motorbike(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(motorbike);
            }
        }

        System.out.println("Nhập biển kiểm soát:");
        String license = RegexData.regexStr(input.nextLine(), REGEX_LICENSE_TRUCK, "Nhập sai, biển số xe tải có dạng: XXB-XX.XXX");

        System.out.println("Nhập tên hãng sản xuất:");
        String production = chooseProduction();

        System.out.println("Nhập năm sản xuất:");
        LocalDate year = LocalDate.parse(RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai ngày tháng, nhập lại:"), formatter);

        System.out.println("Nhập chủ sở hữu:");
        String owner = input.nextLine();

        System.out.println("Nhập trọng tải:");
        Double tonnage = MyException.checkParseDouble();

        Truck truck = new Truck(license, production, year, owner, tonnage);
        vehicleList.add(truck);

        String line = "";
        for (Vehicle vehicle : vehicleList) {
            line += vehicle.getInfo() + "\n";
        }

        System.out.println("Thêm thành công!");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv", line);
    }

    public String chooseProduction() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\production.csv");

        for (String[] strings : list) {
            System.out.println(Arrays.toString(strings));
        }

        String production;
        boolean check = true;

        do {
            System.out.println("Chọn hãng sản xuất: ");
            production = input.nextLine();
            for (String[] strings : list) {
                if (strings[0].equals(production)) {
                    check = false;
                    production = strings[0];
                    break;
                }
            }
        } while (check);

        return production;
    }

    @Override
    public void display() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv");
        vehicleList.clear();

        for (String[] strings : list) {
            if (strings[0].contains("A")) {
                Car car = new Car(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Integer.parseInt(strings[4]),
                        strings[5]);
                vehicleList.add(car);
            } else if (strings[0].contains("B")) {
                Truck truck = new Truck(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(truck);
            } else {
                Motorbike motorbike = new Motorbike(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(motorbike);
            }
        }

        do {
            System.out.println("Danh sách phương tiện:");
            System.out.println("1. Ô tô");
            System.out.println("2. Xe tải");
            System.out.println("3. Xe máy");
            System.out.println("4. Trở về");
            String choose = input.nextLine();

            switch (choose) {
                case "1":
                    for (Vehicle vehicle : vehicleList) {
                        if (vehicle.getLicense().contains("A")) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case "2":
                    for (Vehicle vehicle : vehicleList) {
                        if (vehicle.getLicense().contains("B")) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case "3":
                    for (Vehicle vehicle : vehicleList) {
                        if (vehicle.getLicense().contains("C")) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Chọn sai");
            }
        } while (true);
    }

    @Override
    public void remove() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv");
        vehicleList.clear();

        for (String[] strings : list) {
            if (strings[0].contains("A")) {
                Car car = new Car(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Integer.parseInt(strings[4]),
                        strings[5]);
                vehicleList.add(car);
            } else if (strings[0].contains("B")) {
                Truck truck = new Truck(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(truck);
            } else {
                Motorbike motorbike = new Motorbike(strings[0],
                        strings[1],
                        LocalDate.parse(strings[2]),
                        strings[3],
                        Double.parseDouble(strings[4]));
                vehicleList.add(motorbike);
            }
        }

        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }

        System.out.println("Nhập phương tiện muốn xóa (nhập chính xác biển số xe):");
        String delVehicle = input.nextLine();

        boolean check = false;
        int index = 0;

        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getLicense().equals(delVehicle)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Bạn có muốn xóa phương tiện có BKS là  " + delVehicle + " không ? Chọn yes/no ?");
            String result = input.nextLine();
            switch (result) {
                case "yes":
                    vehicleList.remove(index);
                    System.out.println("Xóa thành công!");

                    String line = "";
                    for (Vehicle vehicle : vehicleList) {
                        line += vehicle.getInfo() + "\n";
                    }

                    ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_phuong_tien\\data\\vehicle.csv", line);
                    return;
                case "no":
                    return;
                default:
                    System.out.println("Chọn yes hoặc no thôi!");
            }
        } else {
            System.out.println("Nhập sai biển số rồi");
        }
    }
}
