package bai_tap_them.quan_ly_dien_thoai.model;

import bai_tap_them.quan_ly_dien_thoai.comma.Comma;

public class OriginPhone extends Phone {
    private String dayInsurance;
    private String location;

    public OriginPhone() {
    }

    public OriginPhone(Integer id, String name, Double price, Integer quantity, String production, String dayInsurance, String location) {
        super(id, name, price, quantity, production);
        this.dayInsurance = dayInsurance;
        this.location = location;
    }

    public String getDayInsurance() {
        return dayInsurance;
    }

    public void setDayInsurance(String dayInsurance) {
        this.dayInsurance = dayInsurance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", dayInsurance: " + dayInsurance +
                ", location: " + location;
    }

    @Override
    public String getInfo() {
        return super.getId() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                super.getPrice() + Comma.COMMA +
                super.getQuantity() + Comma.COMMA +
                super.getProduction() + Comma.COMMA +
                this.getDayInsurance() + Comma.COMMA +
                this.getLocation() + "\n";
    }
}
