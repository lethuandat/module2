package bai_tap_them.quan_ly_truong_hoc.model;

import bai_tap_them.quan_ly_truong_hoc.comma.Comma;

import java.time.LocalDate;

public class Teacher extends Person {
    private String className;
    private Double unitSalary;
    private Integer hourTeach;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String gender, LocalDate date, String address, String className, Double unitSalary, Integer hourTeach) {
        super(id, name, gender, date, address);
        this.className = className;
        this.unitSalary = unitSalary;
        this.hourTeach = hourTeach;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getUnitSalary() {
        return unitSalary;
    }

    public void setUnitSalary(Double unitSalary) {
        this.unitSalary = unitSalary;
    }

    public Integer getHourTeach() {
        return hourTeach;
    }

    public void setHourTeach(Integer hourTeach) {
        this.hourTeach = hourTeach;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", className=" + className +
                ", unitSalary=" + unitSalary +
                ", hourTeach=" + hourTeach;
    }

    @Override
    public String getInfo() {
        return super.getId() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                super.getGender() + Comma.COMMA +
                super.getDate() + Comma.COMMA +
                super.getAddress() + Comma.COMMA +
                this.getClassName() + Comma.COMMA +
                this.getUnitSalary() + Comma.COMMA +
                this.getHourTeach();
    }
}
