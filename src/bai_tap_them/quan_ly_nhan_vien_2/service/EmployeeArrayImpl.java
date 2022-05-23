package bai_tap_them.quan_ly_nhan_vien_2.service;

import bai_tap_them.quan_ly_nhan_vien_2.model.Employee;
import bai_tap_them.quan_ly_nhan_vien_2.model.ManagementStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.ProductionStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.PublicEmployee;

public class EmployeeArrayImpl {
    static Employee[] employees = new Employee[1000];
    //Nếu có 1001 nhân viên thì chương trình xảy ra lỗi, vì array độ dài mảng cố định không thay đổi được.

    static {
        employees[2] = new ManagementStaff("Nam", "12/02/1990", "Đà Nẵng", 10000000, 5.5);
        employees[1] = new ProductionStaff("Linh", "20/03/1993", "Quảng Nam", 200);
        employees[0] = new PublicEmployee("Long", "14/02/1976", "Đà Nẵng", 30);
        employees[4] = new ManagementStaff("Hùng", "20/12/1988", "Hà Nội", 20000000, 10.5);
    }

    public void displayEmployeeArray() {
        for (Employee employee : employees) {
//            if (employee != null) {           Kiểm tra từng phần tử employee, khác null thì in ra.
//                System.out.println(employee);
//            }

            //Kiểm tra từng phần tử employee, nếu thuộc kiểu ManagementStaff thì in ra.
            if (employee instanceof ManagementStaff) {
                System.out.println(employee);
            }
        }

        for (Employee employee : employees) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu ProductionStaff thì in ra.
            if (employee instanceof ProductionStaff) {
                System.out.println(employee);
            }
        }

        for (Employee employee : employees) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu PublicEmployee thì in ra.
            if (employee instanceof PublicEmployee) {
                System.out.println(employee);
            }
        }
    }
}
