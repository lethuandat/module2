package bai_tap_them.quan_ly_nhan_vien_2.service;

import bai_tap_them.quan_ly_nhan_vien_2.model.Employee;
import bai_tap_them.quan_ly_nhan_vien_2.model.ManagementStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.ProductionStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.PublicEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayListImpl {
    static List<Employee> employeeArrayList = new ArrayList<>();
    //Không cần phải khải báo 1000 phần tử trước vì array list là dạng mảng động, kích thước ban đầu = 10,
    //Nếu công ty có 1001 nhân viên thì không xảy ra lỗi,
    //Khi kích thước đầy thì tự tạo mảng mới sao chép các giá trị mảng cũ và kích thước tăng lên 50%
    //Array list có thể thay đổi kích thước so với array, có nhiều phương thức để sử dụng, array thì chỉ có length
    //Array list chỉ lưu đc kiểu đối tượng, tốc độ chậm hơn
    //Array lưu đước kiểu đối tượng và nguyên thủy, tốc độ nhanh hơn

    static {
        employeeArrayList.add(new ManagementStaff("Nam", "12/02/1990", "Đà Nẵng", 10000000, 5.5));
        employeeArrayList.add(new ProductionStaff("Linh", "20/03/1993", "Quảng Nam", 200));
        employeeArrayList.add(new PublicEmployee("Long", "14/02/1976", "Đà Nẵng", 30));
        employeeArrayList.add(new ManagementStaff("Hùng", "20/12/1988", "Hà Nội", 20000000, 10.5));
        employeeArrayList.add(new ManagementStaff("Vân", "20/12/1988", "Hà Nội", 20000000, 10.5));
    }

    public void displayEmployeeArrayList() {
        for (Employee employee : employeeArrayList) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu ManagementStaff thì in ra.
            if (employee instanceof ManagementStaff) {
                System.out.println(employee);
            }
        }

        for (Employee employee : employeeArrayList) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu ProductionStaff thì in ra.
            if (employee instanceof ProductionStaff) {
                System.out.println(employee);
            }
        }

        for (Employee employee : employeeArrayList) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu PublicEmployee thì in ra.
            if (employee instanceof PublicEmployee) {
                System.out.println(employee);
            }
        }
    }
}
