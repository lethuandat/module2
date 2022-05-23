package bai_tap_them.quan_ly_nhan_vien_2.model;

import bai_tap_them.quan_ly_nhan_vien_2.service.IEmployeeService;

import java.math.BigDecimal;

public class ManagementStaff extends Employee implements IEmployeeService {
    private double baseSalary;
    private double coefficient;

    //2 constructor cùng tên nhưng khác tham số -> đa hình ở compile (cơ chế overloading)
    public ManagementStaff() {
    }

    public ManagementStaff(String name, String date, String address, double salary, double coefficient) {
        super(name, date, address);
        this.baseSalary = salary;
        this.coefficient = coefficient;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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
                ", base salary: " + new BigDecimal(baseSalary) +
                ", coefficient: " +
                coefficient +
                ", salary: " + new BigDecimal(getSalary());
    }

    @Override
    public double getSalary() {
        return baseSalary * coefficient;
    }

    //overriding phương thức getSalary() của lớp cha, đa hình ở runtime, khi chạy
    @Override
    public String keepingTime() {
        return "Đã chấm công";
    }
}
