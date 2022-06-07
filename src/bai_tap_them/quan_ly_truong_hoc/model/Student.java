package bai_tap_them.quan_ly_truong_hoc.model;

import bai_tap_them.quan_ly_truong_hoc.comma.Comma;

import java.time.LocalDate;

public class Student extends Person {
    private String idStudent;
    private Double point;

    public Student() {
    }

    public Student(Integer id, String name, String gender, LocalDate date, String address, String idStudent, Double point) {
        super(id, name, gender, date, address);
        this.idStudent = idStudent;
        this.point = point;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", idStudent=" + idStudent +
                ", point=" + point;
    }

    @Override
    public String getInfo() {
        return super.getId() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                super.getGender() + Comma.COMMA +
                super.getDate() + Comma.COMMA +
                super.getAddress() + Comma.COMMA +
                this.getIdStudent() + Comma.COMMA +
                this.getPoint();
    }
}
