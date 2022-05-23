package bai_tap_them.quan_ly_nhan_vien_2.util;

import bai_tap_them.quan_ly_nhan_vien_2.model.Employee;

import java.util.Comparator;

//Muốn sử dựng comparator thì tạo 1 class mới, implements Comparator
//Ghi đè phương thức compare(), sau đó viết lại phương thức compare() này
public class EmployeeSalaryComparator implements Comparator<Employee> {
    //Sắp xếp nhân viên theo lương tăng dần nếu lương bằng nhau thì sắp xếp theo tên giảm dần
    //Phải sử dụng comparator vì ở đây có 2 tiêu chí, comparable không làm được
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalary() - o2.getSalary() > 0) {
            return 1;
        } else if (o1.getSalary() - o2.getSalary() < 0) {
            return -1;
        } else {
            if (o1.getName().compareTo(o2.getName()) > 0) {
                return -1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return 1;
            } else {
                return 1;
            }
        }
    }
}
