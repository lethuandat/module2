package bai_tap_them.quan_ly_tien_dien.model;

import bai_tap_them.quan_ly_tien_dien.comma.Comma;

public class ForeignCustomer extends Customer {
    private String nationality;

    public ForeignCustomer() {
    }

    public ForeignCustomer(String idCustomer, String name, String nationality) {
        super(idCustomer, name);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", nationality: " + nationality;
    }

    @Override
    public String getInfo() {
        return super.getIdCustomer() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                this.getNationality() + Comma.COMMA + "\n";
    }
}
