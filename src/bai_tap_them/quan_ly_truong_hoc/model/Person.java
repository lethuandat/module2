package bai_tap_them.quan_ly_truong_hoc.model;

import java.time.LocalDate;

public abstract class Person {
    private Integer id;
    private String name;
    private String gender;
    private LocalDate date;
    private String address;

    public Person() {
    }

    public Person(Integer id, String name, String gender, LocalDate date, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "id=" + id +
                ", name=" + name +
                ", gender=" + gender +
                ", date=" + date +
                ", address=" + address;
    }

    public abstract String getInfo();
}
