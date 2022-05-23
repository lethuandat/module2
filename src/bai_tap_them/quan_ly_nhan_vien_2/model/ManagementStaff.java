package bai_tap_them.quan_ly_nhan_vien_2.model;

import bai_tap_them.quan_ly_nhan_vien_2.service.IEmployeeService;

public class ManagementStaff extends Employee implements IEmployeeService {
    private double salary;
    private double coefficient;

    //2 constructor cùng tên nhưng khác tham số -> đa hình ở compile (cơ chế overloading)
    public ManagementStaff() {
    }

    public ManagementStaff(String name, String date, String address, double salary, double coefficient) {
        super(name, date, address);
        this.salary = salary;
        this.coefficient = coefficient;
    }

    //overriding phương thức getSalary() của lớp cha, đa hình ở runtime, khi chạy
    @Override
    public double getSalary() {
        return salary * coefficient;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "ManagementStaff " +
                super.toString() +
                ", basic salary: " + salary +
                ", coefficient: " +
                coefficient +
                ", salary: " + getSalary();
    }

    @Override
    public String keepingTime() {
        return "Đã chấm công";
    }
}
