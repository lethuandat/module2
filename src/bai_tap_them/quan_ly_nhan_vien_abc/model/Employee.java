package bai_tap_them.quan_ly_nhan_vien_abc.model;

import java.time.LocalDate;

public abstract class Employee {
    private Integer id;
    private String idEmployee;
    private String name;
    private LocalDate date;
    private String address;

    public Employee() {
    }

    public Employee(Integer id, String idEmployee, String name, LocalDate date, String address) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.name = name;
        this.date = date;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id +
                ", ID: " + idEmployee +
                ", name: " + name +
                ", date: " + date +
                ", address: '" + address;
    }

    public abstract String getInfo();
}
