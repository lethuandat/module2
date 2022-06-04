package bai_tap_them.quan_ly_benh_an.service;

import bai_tap_them.quan_ly_benh_an.model.NormalPatient;
import bai_tap_them.quan_ly_benh_an.model.Patient;
import bai_tap_them.quan_ly_benh_an.model.VipPatient;
import bai_tap_them.quan_ly_benh_an.util.NotFoundMedicalRecordException;
import bai_tap_them.quan_ly_benh_an.util.ReadAndWrite;
import bai_tap_them.quan_ly_benh_an.util.RegexData;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientServiceImpl implements IService {
    List<String[]> list = new ArrayList<>();
    List<Patient> patientList = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public static final String REGEX_ID_PATIENT = "(BA)[-]\\d{3}";
    public static final String REGEX_ID_PATIENTER = "(BN)[-]\\d{3}";
    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    @Override
    public void add() {
        do {
            System.out.println("Bạn muốn thêm bệnh án thường hay vip: ");
            System.out.println("1. Bệnh án thường");
            System.out.println("2. Bệnh án vip");
            System.out.println("3. Trở về");
            System.out.println("Mời bạn chọn");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    addNormal();
                    break;
                case "2":
                    addVip();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Nhập không đúng, mời nhập lại:");
            }
        } while (true);
    }

    public void addNormal() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_benh_an\\data\\medical_records.csv");
        patientList.clear();
        for (String[] strings : list) {
            if (strings.length == 8) {
                NormalPatient normalPatient = new NormalPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        Double.parseDouble(strings[7]));
                patientList.add(normalPatient);
            } else {
                VipPatient vipPatient = new VipPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        strings[7],
                        strings[8]);
                patientList.add(vipPatient);
            }
        }

        int numerial = 0;
        if (patientList.size() == 0) {
            numerial = 1;
        } else {
            numerial = patientList.get(patientList.size() - 1).getNumerical() + 1;
        }

        boolean check = true;
        String patientID = null;

        //Không cho mã bệnh án trùng
        do {
            check = false;
            System.out.println("Nhập mã bệnh án");
            patientID = RegexData.regexStr(input.nextLine(), REGEX_ID_PATIENT, "Nhập sai, mã bệnh án phải có dạng BA-XXX");
            for (Patient item : patientList) {
                if (item.getPatientID().equals(patientID)) {
                    check = true;
                    System.out.println("Mã bệnh án đã tồn tại, nhập lại.");
                }
            }
        } while (check);

        System.out.println("Nhập mã bệnh nhân");
        String patienterID = RegexData.regexStr(input.nextLine(), REGEX_ID_PATIENTER, "Nhập sai, mã bệnh nhân phải có dạng BN-XXX");

        System.out.println("Nhập tên bệnh nhân");
        String namePatient = input.nextLine();

        System.out.println("Nhập ngày nhập viện");
        String dayStart = RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai, ngày tháng phải có dạng dd/mm/yyyy");

        //Ngày ra viện >= ngày nhập viện
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(dayStart, formatter);
        LocalDate end = null;
        String dayEnd = null;
        int minus = 0;
        do {
            System.out.println("Nhập ngày ra viện");
            dayEnd = RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai, ngày tháng phải có dạng dd/mm/yyyy");

            end = LocalDate.parse(dayEnd, formatter);
            minus = Period.between(start, end).getDays();

            if (minus < 0) {
                System.out.println("Ngày ra viện không được nhỏ hơn ngày vào viện, nhập lại đi.");
            }
        } while (minus < 0);

        System.out.println("Lí do nhập viện");
        String reason = input.nextLine();

        System.out.println("Nhập phí nằm viện: ");
        Double fee = Double.parseDouble(input.nextLine());

        NormalPatient normalPatient = new NormalPatient(numerial, patientID, patienterID, namePatient, dayStart, dayEnd, reason, fee);
        patientList.add(normalPatient);

        String line = "";
        for (Patient item : patientList) {
            line += item.getInfo();
        }

        System.out.println("Thêm mới thành công!");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_benh_an\\data\\medical_records.csv", line);
    }

    public void addVip() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_benh_an\\data\\medical_records.csv");
        patientList.clear();
        for (String[] strings : list) {
            if (strings.length == 8) {
                NormalPatient normalPatient = new NormalPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        Double.parseDouble(strings[7]));
                patientList.add(normalPatient);
            } else {
                VipPatient vipPatient = new VipPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        strings[7],
                        strings[8]);
                patientList.add(vipPatient);
            }
        }

        int numerial = 0;
        if (patientList.size() == 0) {
            numerial = 1;
        } else {
            numerial = patientList.get(patientList.size() - 1).getNumerical() + 1;
        }

        boolean check = true;
        String patientID = null;
        //Không cho mã bệnh án trùng
        do {
            check = false;
            System.out.println("Nhập mã bệnh án");
            patientID = RegexData.regexStr(input.nextLine(), REGEX_ID_PATIENT, "Nhập sai, mã bệnh án phải có dạng BA-XXX");
            for (Patient item : patientList) {
                if (item.getPatientID().equals(patientID)) {
                    check = true;
                    System.out.println("Mã bệnh án đã tồn tại, nhập lại.");
                }
            }
        } while (check);

        System.out.println("Nhập mã bệnh nhân");
        String patienterID = RegexData.regexStr(input.nextLine(), REGEX_ID_PATIENTER, "Nhập sai, mã bệnh nhân phải có dạng BN-XXX");

        System.out.println("Nhập tên bệnh nhân");
        String namePatient = input.nextLine();

        System.out.println("Nhập ngày nhập viện");
        String dayStart = RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai, ngày tháng phải có dạng dd/mm/yyyy");

        //Ngày ra viện >= ngày nhập viện
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(dayStart, formatter);
        LocalDate end = null;
        String dayEnd = null;
        int minus = 0;
        do {
            System.out.println("Nhập ngày ra viện");
            dayEnd = RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai, ngày tháng phải có dạng dd/mm/yyyy");

            end = LocalDate.parse(dayEnd, formatter);
            minus = Period.between(start, end).getDays();

            if (minus < 0) {
                System.out.println("Ngày ra viện không được nhỏ hơn ngày vào viện, nhập lại đi.");
            }
        } while (minus < 0);

        System.out.println("Lí do nhập viện");
        String reason = input.nextLine();

        String type = chooseType();

        System.out.println("Nhập thời hạn vip: ");
        String duration = RegexData.regexStr(input.nextLine(), REGEX_TIME, "Nhập sai, ngày tháng phải có dạng dd/mm/yyyy");

        VipPatient vipPatient = new VipPatient(numerial, patientID, patienterID, namePatient, dayStart, dayEnd, reason, type, duration);
        patientList.add(vipPatient);

        String line = "";
        for (Patient item : patientList) {
            line += item.getInfo();
        }

        System.out.println("Thêm mới thành công!");
        ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_benh_an\\data\\medical_records.csv", line);
    }

    public String chooseType() {
        do {
            System.out.println("Nhập loại vip:");
            System.out.println("1. VIP I");
            System.out.println("2. VIP II");
            System.out.println("3. VIP III");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    return "VIP I";
                case "2":
                    return "VIP II";
                case "3":
                    return "VIP III";
                default:
                    System.out.println("Chọn 1 trong 3 loại trên thôi.");
            }
        } while (true);
    }

    @Override
    public void remove() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_benh_an\\data\\medical_records.csv");
        patientList.clear();
        for (String[] strings : list) {
            if (strings.length == 8) {
                NormalPatient normalPatient = new NormalPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        Double.parseDouble(strings[7]));
                patientList.add(normalPatient);
            } else {
                VipPatient vipPatient = new VipPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        strings[7],
                        strings[8]);
                patientList.add(vipPatient);
            }
        }

        System.out.println("Nhập mã bệnh án");
        String patientID = null;

        boolean flag = true;
        do {
            flag = false;
            patientID = input.nextLine();
            try {
                if (!patientID.matches(REGEX_ID_PATIENT)) {
                    flag = true;
                    throw new NotFoundMedicalRecordException("Mã bệnh án không đúng");
                }
            } catch (NotFoundMedicalRecordException e) {
                System.err.println(e.getMessage());
            }
        } while (flag);

        boolean check = false;
        int index = 0;
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getPatientID().equals(patientID)) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Bạn có muốn xóa bệnh án " + patientID + " ? Chọn yes/no ?");
            String result = input.nextLine();
            switch (result) {
                case "yes":
                    patientList.remove(index);
                    System.out.println("Xóa thành công!");

                    String line = "";
                    for (Patient item : patientList) {
                        line += item.getInfo();
                    }

                    ReadAndWrite.writeTextFile("src\\bai_tap_them\\quan_ly_benh_an\\data\\medical_records.csv", line);
                    display();
                    break;
                case "no":
                    return;
                default:
                    System.out.println("Chọn yes hoặc no thôi!");
            }
        } else {
            System.out.println("Mã bệnh án không tồn tại.");
        }
    }

    @Override
    public void display() {
        list.clear();
        list = ReadAndWrite.readTextFile("src\\bai_tap_them\\quan_ly_benh_an\\data\\medical_records.csv");
        patientList.clear();
        for (String[] strings : list) {
            if (strings.length == 8) {
                NormalPatient normalPatient = new NormalPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        Double.parseDouble(strings[7]));
                patientList.add(normalPatient);
            } else {
                VipPatient vipPatient = new VipPatient(Integer.parseInt(strings[0]),
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        strings[6],
                        strings[7],
                        strings[8]);
                patientList.add(vipPatient);
            }
        }

        for (Patient item : patientList) {
            System.out.println(item);
        }
    }
}
