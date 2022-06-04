package bai_tap_them.quan_ly_tien_dien.service.impl;

import bai_tap_them.quan_ly_tien_dien.comma.Comma;
import bai_tap_them.quan_ly_tien_dien.model.Check;
import bai_tap_them.quan_ly_tien_dien.model.ForeignCustomer;
import bai_tap_them.quan_ly_tien_dien.model.VietNamCustomer;
import bai_tap_them.quan_ly_tien_dien.service.CheckService;
import bai_tap_them.quan_ly_tien_dien.utils.ReadAndWrite;
import bai_tap_them.quan_ly_tien_dien.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckServiceImpl implements CheckService {
    List<String[]> list = new ArrayList<>();
    List<VietNamCustomer> customerVnList = new ArrayList<>();
    List<ForeignCustomer> customerNnList = new ArrayList<>();
    List<Check> checkList = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    @Override
    public void add() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv");
        customerVnList.clear();
        customerNnList.clear();
        for (String[] item : list) {
            if (item[0].contains("KHVN")) {
                VietNamCustomer vietNamCustomer = new VietNamCustomer(item[0],
                        item[1],
                        item[2],
                        Double.parseDouble(item[3]));
                customerVnList.add(vietNamCustomer);
            } else {
                ForeignCustomer foreignCustomer = new ForeignCustomer(item[0], item[1], item[2]);
                customerNnList.add(foreignCustomer);
            }
        }

        System.out.println("Danh sách khách hàng hiện có:");
        for (VietNamCustomer item : customerVnList) {
            System.out.println(item);
        }
        for (ForeignCustomer item : customerNnList) {
            System.out.println(item);
        }

        boolean check = true;
        String idCustomer = "";
        double quota = 0;
        do {
            System.out.println("Nhập mã khách hàng: ");
            idCustomer = input.nextLine();

            for (VietNamCustomer item : customerVnList) {
                if (item.getIdCustomer().equals(idCustomer)) {
                    check = false;
                    idCustomer = item.getIdCustomer();
                    quota = item.getQuota();
                    break;
                }
            }

            for (ForeignCustomer item : customerNnList) {
                if (item.getIdCustomer().equals(idCustomer)) {
                    check = false;
                    idCustomer = item.getIdCustomer();
                    break;
                }
            }

            if (check) {
                System.out.println("Nhập mã khách hàng sai, Nhập lại!");
            }
        } while (check);

        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\hoaDon.csv");
        checkList.clear();
        for (String[] item : list) {
            Check checkItem = new Check(item[0],
                    item[1],
                    item[2],
                    Double.parseDouble(item[3]),
                    Double.parseDouble(item[4]),
                    Double.parseDouble(item[5]));
            checkList.add(checkItem);
        }

        String idCheck = "";
        int max = 0;
        if (checkList.size() == 0) {
            idCheck = "MHD-001";
        } else {
            for (Check item : checkList) {
                if (Integer.parseInt(item.getIdCheck().split("-")[1]) > max) {
                    max = Integer.parseInt(item.getIdCheck().split("-")[1]);
                }
                idCheck = "MHD-" + String.format("%3s", max + 1).replaceAll(" ", "0");
            }
        }

        System.out.println("Nhập ngày ra hóa đơn: ");
        String date = RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập ngày tháng sai!");

        System.out.println("Nhập số lượng kW tiêu thụ: ");
        double quantity = Double.parseDouble(input.nextLine());

        System.out.println("Nhập đơn giá: ");
        double unitPrice = Double.parseDouble(input.nextLine());

        double totalMoney = 0;
        if (idCustomer.contains("KHNN")) {
            if (quantity <= quota) {
                totalMoney = unitPrice * quantity;
            } else {
                totalMoney = unitPrice * quantity * quota + unitPrice * 2.5 * (quantity - quota);
            }
        } else {
            totalMoney = unitPrice * quantity;
        }

        Check checkNew = new Check(idCheck, idCustomer, date, quantity, unitPrice, totalMoney);
        checkList.add(checkNew);

        String line = "";
        for (Check item : checkList) {
            line += item.getInfo() + "\n";
        }

        System.out.println("Thêm thành công!");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\hoaDon.csv", line);
    }

    @Override
    public void display() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\hoaDon.csv");
        checkList.clear();
        for (String[] item : list) {
            Check checkItem = new Check(item[0],
                    item[1],
                    item[2],
                    Double.parseDouble(item[3]),
                    Double.parseDouble(item[4]),
                    Double.parseDouble(item[5]));
            checkList.add(checkItem);
        }

        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv");
        customerVnList.clear();
        customerNnList.clear();
        for (String[] item : list) {
            if (item[0].contains("KHVN")) {
                VietNamCustomer vietNamCustomer = new VietNamCustomer(item[0],
                        item[1],
                        item[2],
                        Double.parseDouble(item[3]));
                customerVnList.add(vietNamCustomer);
            } else {
                ForeignCustomer foreignCustomer = new ForeignCustomer(item[0], item[1], item[2]);
                customerNnList.add(foreignCustomer);
            }
        }

        System.out.println("Danh sách hóa đơn");
        for (Check item : checkList) {
            for (VietNamCustomer value : customerVnList) {
                if (item.getIdCustomer().equals(value.getIdCustomer())) {
                    System.out.println(item.getIdCheck() + Comma.COMMA +
                            value.getName() + Comma.COMMA +
                            item.getDay() + Comma.COMMA +
                            item.getQuantity() + Comma.COMMA +
                            item.getUnitPrice() + Comma.COMMA +
                            item.getTotalMoney());
                }
            }

            for (ForeignCustomer value : customerNnList) {
                if (item.getIdCustomer().equals(value.getIdCustomer())) {
                    System.out.println(item.getIdCheck() + Comma.COMMA +
                            value.getName() + Comma.COMMA +
                            item.getDay() + Comma.COMMA +
                            item.getQuantity() + Comma.COMMA +
                            item.getUnitPrice() + Comma.COMMA +
                            item.getTotalMoney());
                }
            }
        }
    }

    @Override
    public void edit() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\hoaDon.csv");
        checkList.clear();
        for (String[] item : list) {
            Check checkItem = new Check(item[0],
                    item[1],
                    item[2],
                    Double.parseDouble(item[3]),
                    Double.parseDouble(item[4]),
                    Double.parseDouble(item[5]));
            checkList.add(checkItem);
        }

        System.out.println("Danh sách hóa đơn");
        for (Check item : checkList) {
            System.out.println(item);
        }

        System.out.println("Chọn mã hóa đơn cần sửa: ");
        String idCheck = input.nextLine();

        boolean flag = false;
        int index = 0;
        for (int i = 0; i < checkList.size(); i++) {
            if (checkList.get(i).getIdCheck().equals(idCheck)) {
                flag = true;
                index = i;
                break;
            }
        }

        if (flag) {
            list.clear();
            list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\khachHang.csv");
            customerVnList.clear();
            customerNnList.clear();
            for (String[] item : list) {
                if (item[0].contains("KHVN")) {
                    VietNamCustomer vietNamCustomer = new VietNamCustomer(item[0],
                            item[1],
                            item[2],
                            Double.parseDouble(item[3]));
                    customerVnList.add(vietNamCustomer);
                } else {
                    ForeignCustomer foreignCustomer = new ForeignCustomer(item[0], item[1], item[2]);
                    customerNnList.add(foreignCustomer);
                }
            }

            System.out.println("Danh sách khách hàng hiện có:");
            for (VietNamCustomer item : customerVnList) {
                System.out.println(item);
            }
            for (ForeignCustomer item : customerNnList) {
                System.out.println(item);
            }

            boolean check = true;
            String idCustomer = "";
            double quota = 0;
            do {
                System.out.println("Nhập mã khách hàng: ");
                idCustomer = input.nextLine();

                for (VietNamCustomer item : customerVnList) {
                    if (item.getIdCustomer().equals(idCustomer)) {
                        check = false;
                        idCustomer = item.getIdCustomer();
                        quota = item.getQuota();
                        break;
                    }
                }

                for (ForeignCustomer item : customerNnList) {
                    if (item.getIdCustomer().equals(idCustomer)) {
                        check = false;
                        idCustomer = item.getIdCustomer();
                        break;
                    }
                }

                if (check) {
                    System.out.println("Nhập mã khách hàng sai, Nhập lại!");
                }
            } while (check);

            System.out.println("Nhập ngày ra hóa đơn: ");
            String date = RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập ngày tháng sai!");

            System.out.println("Nhập số lượng kW tiêu thụ: ");
            double quantity = Double.parseDouble(input.nextLine());

            System.out.println("Nhập đơn giá: ");
            double unitPrice = Double.parseDouble(input.nextLine());

            double totalMoney = 0;
            if (idCustomer.contains("KHVN")) {
                if (quantity <= quota) {
                    totalMoney = unitPrice * quantity;
                } else {
                    totalMoney = unitPrice * quantity * quota + unitPrice * 2.5 * (quantity - quota);
                }
            } else {
                totalMoney = unitPrice * quantity;
            }

            checkList.get(index).setIdCustomer(idCustomer);
            checkList.get(index).setDay(date);
            checkList.get(index).setQuantity(quantity);
            checkList.get(index).setUnitPrice(unitPrice);
            checkList.get(index).setTotalMoney(totalMoney);

            String line = "";
            for (Check item : checkList) {
                line += item.getInfo() + "\n";
            }

            System.out.println("Sửa thành công!");
            ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_tien_dien\\data\\hoaDon.csv", line);
        } else {
            System.out.println("Mã hóa đơn bạn nhập không đúng!");
        }
    }
}
