package bai_tap_them.quan_ly_nhan_vien_2.model;

import java.math.BigDecimal;

public class PublicEmployee extends Employee {
    private int workDays;

    //2 constructor cùng tên nhưng khác tham số -> đa hình ở compile (cơ chế overloading)
    public PublicEmployee() {
    }

    public PublicEmployee(String name, String date, String address, int workDays) {
        super(name, date, address);
        this.workDays = workDays;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    @Override
    public String toString() {
        return "PublicEmployee: " +
                super.toString() +
                ", workDays: " +
                workDays +
                ", salary: " + new BigDecimal(getSalary());
    }

    //overriding phương thức getSalary() của lớp cha, đa hình ở runtime, khi chạy
    @Override
    public double getSalary() {
        return 50000 * workDays;
    }
}
