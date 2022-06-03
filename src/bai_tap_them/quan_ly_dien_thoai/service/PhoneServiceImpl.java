package bai_tap_them.quan_ly_dien_thoai.service;

import bai_tap_them.quan_ly_benh_an.util.NotFoundMedicalRecordException;
import bai_tap_them.quan_ly_dien_thoai.model.HandedPhone;
import bai_tap_them.quan_ly_dien_thoai.model.OriginPhone;
import bai_tap_them.quan_ly_dien_thoai.model.Phone;
import bai_tap_them.quan_ly_dien_thoai.utils.NotFoundProductException;
import bai_tap_them.quan_ly_dien_thoai.utils.ReadAndWrite;
import bai_tap_them.quan_ly_dien_thoai.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneServiceImpl implements IService {
    List<String[]> list = new ArrayList<>();
    List<Phone> phoneList = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public static final String REGEX_POSITIVE_NUMBER = "[1-9][0-9]*";

    @Override
    public void display() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv");
        phoneList.clear();

        for (String[] item : list) {
            if (item[6].equals("Toàn Quốc") || item[6].equals("Quốc Tế")) {
                OriginPhone originPhone = new OriginPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(originPhone);
            } else {
                HandedPhone handedPhone = new HandedPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(handedPhone);
            }
        }

        System.out.println("Danh sách điện thoại: ");
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
    }

    @Override
    public void add() {
        do {
            System.out.println("Bạn muốn thêm bệnh điện thoại chính hãng hay xách tay: ");
            System.out.println("1. Chính hãng");
            System.out.println("2. Xách tay");
            System.out.println("3. Trở về");
            System.out.println("Mời bạn chọn");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    addOrigin();
                    break;
                case "2":
                    addHanded();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Nhập không đúng, mời nhập lại:");
            }
        } while (true);
    }

    public void addOrigin() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv");
        phoneList.clear();

        for (String[] item : list) {
            if (item[6].equals("Toàn Quốc") || item[6].equals("Quốc Tế")) {
                OriginPhone originPhone = new OriginPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(originPhone);
            } else {
                HandedPhone handedPhone = new HandedPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(handedPhone);
            }
        }

        int id = 0;
        if (phoneList.size() == 0) {
            id = 1;
        } else {
            id = phoneList.get(phoneList.size() - 1).getId() + 1;
        }

        System.out.println("Nhập tên điện thoại: ");
        String name = input.nextLine();

        System.out.println("Nhập giá điện thoại: ");
        Double price = Double.parseDouble(RegexData.regexStr(input.nextLine(), REGEX_POSITIVE_NUMBER, "Phải nhập số dương!!!"));

        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(RegexData.regexStr(input.nextLine(), REGEX_POSITIVE_NUMBER, "Phải nhập số dương!!!"));

        System.out.println("Nhập nhà sản xuất: ");
        String production = input.nextLine();

        boolean check = true;
        String dayInsurance = null;

        do {
            check = false;
            System.out.println("Nhập thời gian bảo hành: ");
            dayInsurance = RegexData.regexStr(input.nextLine(), REGEX_POSITIVE_NUMBER, "Phải nhập số dương!!!");
            if (Integer.parseInt(dayInsurance) > 730) {
                System.out.println("Thời giản bảo hành phải nhỏ hơn 2 năm ( < 730 ngày)");
                check = true;
            }
        } while (check);

        String location = chooseLocation();

        OriginPhone originPhone = new OriginPhone(id, name, price, quantity, production, dayInsurance, location);
        phoneList.add(originPhone);

        String line = "";
        for (Phone phone : phoneList) {
            line += phone.getInfo();
        }

        System.out.println("Thêm thành công.");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv", line);
    }

    public void addHanded() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv");
        phoneList.clear();

        for (String[] item : list) {
            if (item[6].equals("Toàn Quốc") || item[6].equals("Quốc Tế")) {
                OriginPhone originPhone = new OriginPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(originPhone);
            } else {
                HandedPhone handedPhone = new HandedPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(handedPhone);
            }
        }

        int id = 0;
        if (phoneList.size() == 0) {
            id = 1;
        } else {
            id = phoneList.get(phoneList.size() - 1).getId() + 1;
        }

        System.out.println("Nhập tên điện thoại: ");
        String name = input.nextLine();

        System.out.println("Nhập giá điện thoại: ");
        Double price = Double.parseDouble(RegexData.regexStr(input.nextLine(), REGEX_POSITIVE_NUMBER, "Phải nhập số dương!!!"));

        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(RegexData.regexStr(input.nextLine(), REGEX_POSITIVE_NUMBER, "Phải nhập số dương!!!"));

        System.out.println("Nhập nhà sản xuất: ");
        String production = input.nextLine();

        boolean check = true;
        String country = null;
        do {
            check = false;
            System.out.println("Nhập quốc gia xách tay: ");
            country = input.nextLine();
            if (country.equals("Việt Nam")) {
                check = true;
                System.out.println("Quốc gia xách tay phải khác Việt Nam.");
            }
        } while (check);

        String status = chooseStatus();

        HandedPhone handedPhone = new HandedPhone(id, name, price, quantity, production, country, status);
        phoneList.add(handedPhone);

        String line = "";
        for (Phone phone : phoneList) {
            line += phone.getInfo();
        }

        System.out.println("Thêm thành công.");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv", line);
    }

    public String chooseStatus() {
        do {
            System.out.println("Nhập trạng thái:");
            System.out.println("1. Đã sửa chữa");
            System.out.println("2. Chưa sửa chữa");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    return "Đã sửa chữa";
                case "2":
                    return "Chưa sửa chữa";
                default:
                    System.out.println("Chọn 1 trong 2 loại trên thôi.");
            }
        } while (true);
    }

    public String chooseLocation() {
        do {
            System.out.println("Nhập phạm vi bảo hành:");
            System.out.println("1. Toàn Quốc");
            System.out.println("2. Quốc Tế");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    return "Toàn Quốc";
                case "2":
                    return "Quốc Tế";
                default:
                    System.out.println("Chọn 1 trong 2 loại trên thôi.");
            }
        } while (true);
    }

    @Override
    public void search() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv");
        phoneList.clear();

        for (String[] item : list) {
            if (item[6].equals("Toàn Quốc") || item[6].equals("Quốc Tế")) {
                OriginPhone originPhone = new OriginPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(originPhone);
            } else {
                HandedPhone handedPhone = new HandedPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(handedPhone);
            }
        }

        System.out.println("Bạn cần tìm gì?");
        String searchStr = input.nextLine();

        int count = 0;
        for (Phone phone : phoneList) {
            if (phone.getId().toString().contains(searchStr) || phone.getName().contains(searchStr)) {
                System.out.println(phone);
                count++;
            }
        }

        System.out.println("Tìm thấy " + count + " sản phẩm.");
    }

    @Override
    public void remove() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv");
        phoneList.clear();

        for (String[] item : list) {
            if (item[6].equals("Toàn Quốc") || item[6].equals("Quốc Tế")) {
                OriginPhone originPhone = new OriginPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(originPhone);
            } else {
                HandedPhone handedPhone = new HandedPhone(Integer.parseInt(item[0]),
                        item[1],
                        Double.parseDouble(item[2]),
                        Integer.parseInt(item[3]),
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(handedPhone);
            }
        }

        System.out.println("Nhập id muốn xóa:");
        int id = 0;

        boolean flag = true;
        do {
            flag = false;
            try {
                id = Integer.parseInt(input.nextLine());
                if (!String.valueOf(id).matches(REGEX_POSITIVE_NUMBER)) {
                    flag = true;
                    throw new NotFoundProductException("ID không đúng");
                }
            } catch (NumberFormatException e) {
                flag = true;
                System.err.println("Không được nhập chữ");
            } catch (NotFoundProductException e) {
                System.err.println(e.getMessage());
            }
        } while (flag);

        boolean check = false;
        int index = 0;
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getId().equals(id)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Bạn có muốn xóa điện thoại có id là  " + id + " ? Chọn yes/no ?");
            String result = input.nextLine();
            switch (result) {
                case "yes":
                    phoneList.remove(index);
                    System.out.println("Xóa thành công!");

                    String line = "";
                    for (Phone item : phoneList) {
                        line += item.getInfo();
                    }

                    ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_dien_thoai\\data\\mobiles.csv", line);
                    display();
                    break;
                case "no":
                    return;
                default:
                    System.out.println("Chọn yes hoặc no thôi!");
            }
        } else {
            System.out.println("ID không tồn tại.");
        }
    }
}
