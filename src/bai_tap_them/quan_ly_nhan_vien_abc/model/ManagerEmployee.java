package bai_tap_them.quan_ly_nhan_vien_abc.model;

import bai_tap_them.quan_ly_nhan_vien_abc.comma.Comma;

import java.time.LocalDate;

public class ManagerEmployee extends Employee {
    private Double baseSalary;
    private Double factor;

    public ManagerEmployee() {
    }

    public ManagerEmployee(Integer id, String idEmployee, String name, LocalDate date, String address, Double baseSalary, Double factor) {
        super(id, idEmployee, name, date, address);
        this.baseSalary = baseSalary;
        this.factor = factor;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", baseSalary: " + baseSalary +
                ", factor: " + factor;
    }

    @Override
    public String getInfo() {
        return super.getId() + Comma.COMMA +
                super.getIdEmployee() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                super.getDate() + Comma.COMMA +
                super.getAddress() + Comma.COMMA +
                this.getBaseSalary() + Comma.COMMA +
                this.getFactor();
    }
}
