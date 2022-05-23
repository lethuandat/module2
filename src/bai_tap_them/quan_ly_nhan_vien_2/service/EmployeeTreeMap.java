package bai_tap_them.quan_ly_nhan_vien_2.service;

import bai_tap_them.quan_ly_nhan_vien_2.model.Employee;
import bai_tap_them.quan_ly_nhan_vien_2.model.ManagementStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.ProductionStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.PublicEmployee;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EmployeeTreeMap {
    static Map<Integer, Employee> integerEmployeeMap = new TreeMap<>();

    static {
        integerEmployeeMap.put(1, new ManagementStaff("Nam", "12/02/1990", "Đà Nẵng", 10000000, 5.5));
        integerEmployeeMap.put(5, new ProductionStaff("Linh", "20/03/1993", "Quảng Nam", 200));
        integerEmployeeMap.put(4, new PublicEmployee("Long", "14/02/1976", "Đà Nẵng", 30));
        integerEmployeeMap.put(3, new ManagementStaff("Hùng", "20/12/1988", "Hà Nội", 20000000, 10.5));
        integerEmployeeMap.put(2, new ManagementStaff("Dương", "20/12/1988", "Hà Nội", 20000000, 10.5));
    }

    public void displayByTreeMap() {
        for (Integer item : integerEmployeeMap.keySet()) {
            //Dùng containsKey() để kiểm tra xem Mã NV đã tồn tại hay chưa
            if (integerEmployeeMap.containsKey(item)) {
                System.out.println("Mã NV: " + item + ", " + integerEmployeeMap.get(item));
            }

        }
    }
}
