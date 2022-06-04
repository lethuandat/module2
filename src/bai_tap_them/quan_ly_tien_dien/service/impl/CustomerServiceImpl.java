package bai_tap_them.quan_ly_tien_dien.service.impl;

import bai_tap_them.quan_ly_tien_dien.model.Customer;
import bai_tap_them.quan_ly_tien_dien.model.ForeignCustomer;
import bai_tap_them.quan_ly_tien_dien.model.VietNamCustomer;
import bai_tap_them.quan_ly_tien_dien.service.CustomerService;
import bai_tap_them.quan_ly_tien_dien.utils.ReadAndWrite;
import bai_tap_them.quan_ly_tien_dien.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    List<String[]> list = new ArrayList<>();
    List<Customer> customerList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public static final String REGEX_KHVN = "(KHVN)[-]\\d{5}";
    public static final String REGEX_KHNN = "(KHNN)[-]\\d{5}";

    @Override
    public void add() {
        do {
            System.out.println("Bạn muốn thêm khách Việt Nam hay nước ngoài: ");
            System.out.println("1. Khách Việt Nam");
            System.out.println("2. Khách nước ngoài");
            System.out.println("3. Trở về");
            System.out.println("Mời bạn chọn");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    addVnCustomer();
                    break;
                case "2":
                    addNnCustomer();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Nhập không đúng, mời nhập lại:");
            }
        } while (true);
    }

    public void addVnCustomer() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv");
        customerList.clear();
        for (String[] item : list) {
            if (item[0].contains("KHVN")) {
                VietNamCustomer vietNamCustomer = new VietNamCustomer(item[0],
                        item[1],
                        item[2],
                        Double.parseDouble(item[3]));
                customerList.add(vietNamCustomer);
            } else {
                ForeignCustomer foreignCustomer = new ForeignCustomer(item[0], item[1], item[2]);
                customerList.add(foreignCustomer);
            }
        }

        //Không cho mã khách hàng trùng
        boolean check = true;
        String idCustomer = null;

        do {
            check = false;
            System.out.println("Nhập mã khách hàng: ");
            idCustomer = RegexData.regexStr(input.nextLine(), REGEX_KHVN, "Nhập sai, mã khách hàng phải có dạng KHVN-XXXXX, (X: 0 -> 9)");
            for (Customer item : customerList) {
                if (item.getIdCustomer().equals(idCustomer)) {
                    check = true;
                    System.out.println("Mã khách hàng đã tồn tại, nhập lại.");
                }
            }
        } while (check);

        System.out.println("Nhập họ tên khách hàng: ");
        String name = input.nextLine();

        String type = chooseType();

        System.out.println("Nhập định mức tiêu thụ: ");
        Double quota = Double.parseDouble(input.nextLine());

        VietNamCustomer vietNamCustomer = new VietNamCustomer(idCustomer, name, type, quota);
        customerList.add(vietNamCustomer);

        String line = "";
        for (Customer item : customerList) {
            line += item.getInfo();
        }

        System.out.println("Thêm thành công");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv", line);
    }

    public String chooseType() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\loaiKhach.csv");

        System.out.println("Danh sách loại khách hàng: ");
        for (String[] item : list) {
            System.out.println(item[0] + ", " + item[1] + "\n");
        }

        System.out.println("Chọn loại khách hàng:");
        String chosen = input.nextLine();

        do {
            for (String[] item : list) {
                if (chosen.equals(item[0])) {
                    return item[1];
                }
            }
            System.out.println("Loại khách hàng không đúng.");
            System.out.println("Chọn lại loại khách hàng");
            chosen = input.nextLine();
        } while (true);

    }

    public void addNnCustomer() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv");
        customerList.clear();
        for (String[] item : list) {
            if (item[0].contains("KHVN")) {
                VietNamCustomer vietNamCustomer = new VietNamCustomer(item[0],
                        item[1],
                        item[2],
                        Double.parseDouble(item[3]));
                customerList.add(vietNamCustomer);
            } else {
                ForeignCustomer foreignCustomer = new ForeignCustomer(item[0], item[1], item[2]);
                customerList.add(foreignCustomer);
            }
        }

        //Không cho mã khách hàng trùng
        boolean check = true;
        String idCustomer = null;

        do {
            check = false;
            System.out.println("Nhập mã khách hàng: ");
            idCustomer = RegexData.regexStr(input.nextLine(), REGEX_KHNN, "Nhập sai, mã khách hàng phải có dạng KHNN-XXXXX, (X: 0 -> 9)");
            for (Customer item : customerList) {
                if (item.getIdCustomer().equals(idCustomer)) {
                    check = true;
                    System.out.println("Mã khách hàng đã tồn tại, nhập lại.");
                }
            }
        } while (check);

        System.out.println("Nhập họ tên khách hàng: ");
        String name = input.nextLine();

        System.out.println("Nhập quốc tịch: ");
        String nationality = input.nextLine();

        ForeignCustomer foreignCustomer = new ForeignCustomer(idCustomer, name, nationality);
        customerList.add(foreignCustomer);

        String line = "";
        for (Customer item : customerList) {
            line += item.getInfo();
        }

        System.out.println("Thêm thành công");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv", line);
    }

    @Override
    public void display() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv");
        customerList.clear();
        for (String[] item : list) {
            if (item[0].contains("KHVN")) {
                VietNamCustomer vietNamCustomer = new VietNamCustomer(item[0],
                        item[1],
                        item[2],
                        Double.parseDouble(item[3]));
                customerList.add(vietNamCustomer);
            } else {
                ForeignCustomer foreignCustomer = new ForeignCustomer(item[0], item[1], item[2]);
                customerList.add(foreignCustomer);
            }
        }

        for (Customer item : customerList) {
            System.out.println(item);
        }
    }

    @Override
    public void find() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv");
        customerList.clear();
        for (String[] item : list) {
            if (item[0].contains("KHVN")) {
                VietNamCustomer vietNamCustomer = new VietNamCustomer(item[0],
                        item[1],
                        item[2],
                        Double.parseDouble(item[3]));
                customerList.add(vietNamCustomer);
            } else {
                ForeignCustomer foreignCustomer = new ForeignCustomer(item[0], item[1], item[2]);
                customerList.add(foreignCustomer);
            }
        }

        System.out.println("Nhập tên khách hàng cần tìm kiếm: ");
        String customerFind = input.nextLine();
        boolean check = false;

        for (Customer item : customerList) {
            if (item.getName().contains(customerFind)) {
                System.out.println(item);
                check = true;
            }
        }

        if (!check) {
            System.out.println("Không tìm thấy khách hàng nào!");
        }
    }
}
