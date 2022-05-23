package bai_tap_them.quan_ly_nhan_vien_2.service;

import bai_tap_them.quan_ly_nhan_vien_2.model.Employee;
import bai_tap_them.quan_ly_nhan_vien_2.model.ManagementStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.ProductionStaff;
import bai_tap_them.quan_ly_nhan_vien_2.model.PublicEmployee;
import bai_tap_them.quan_ly_nhan_vien_2.util.EmployeeSalaryComparator;

import java.util.*;

public class EmployeeLinkedList {
    static List<Employee> employeeLinkedList = new LinkedList<>();


    static {
        employeeLinkedList.add(new ManagementStaff("Nam", "12/02/1990", "Đà Nẵng", 10000000, 5.5));
        employeeLinkedList.add(new ProductionStaff("Linh", "20/03/1993", "Quảng Nam", 200));
        employeeLinkedList.add(new PublicEmployee("Long", "14/02/1976", "Đà Nẵng", 30));
        employeeLinkedList.add(new ManagementStaff("Hùng", "20/12/1988", "Hà Nội", 20000000, 10.5));
        employeeLinkedList.add(new ManagementStaff("Dương", "20/12/1988", "Hà Nội", 20000000, 10.5));
    }

    public void sortByName() {
        Collections.sort(employeeLinkedList);
        for (Employee employee : employeeLinkedList) {
            System.out.println(employee);
        }
    }

    public void sortBySalary() {
        employeeLinkedList.sort(new EmployeeSalaryComparator());
        for (Employee employee : employeeLinkedList) {
            System.out.println(employee);
        }
    }

    //Không nên dùng for i để duyệt linked list, vì mỗi để duyệt đến phần tử bất kì nào cũng phải duyệt từ đầu danh sách -> giảm hiệu suất
    //Công ty ABC thay đổi nhân sự liên tục nên dùng linked list
    //Vì linked list lưu trữ danh sách theo dạng liêt kết
    //Khi thêm: vào vị trí thì trỏ địa chỉ nút trước vị trí thêm tới nút mới thêm, địa chỉ nút mới thêm sẽ trỏ vào nút sau vị trí thêm.
    //Khi xóa: xóa nút cần xóa, địa chỉ nút trước nút bị xóa sẽ trỏ tới nút sau nút bị xóa
    //Vì vậy, Ưu điểm của linkedlist là thêm sửa xóa nhanh, nhược điểm là truy xuất phần tử chậm
    //Còn array list ưu điểm là truy xuất phần tử nhanh, thêm sửa xóa chậm, vì mỗi lần thao tác, phải dịch toàn bộ phần tử
    //từ vị trí cần thêm, xóa sang phải, trái.
    public void displayEmployeeLinkedList() {
        for (Employee employee : employeeLinkedList) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu ManagementStaff thì in ra.
            if (employee instanceof ManagementStaff) {
                System.out.println(employee);
            }
        }

        for (Employee employee : employeeLinkedList) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu ProductionStaff thì in ra.
            if (employee instanceof ProductionStaff) {
                System.out.println(employee);
            }
        }

        for (Employee employee : employeeLinkedList) {
            //Kiểm tra từng phần tử employee, nếu thuộc kiểu PublicEmployee thì in ra.
            if (employee instanceof PublicEmployee) {
                System.out.println(employee);
            }
        }
    }
}
