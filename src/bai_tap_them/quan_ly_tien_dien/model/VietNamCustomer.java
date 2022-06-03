package bai_tap_them.quan_ly_tien_dien.model;

import bai_tap_them.quan_ly_tien_dien.comma.Comma;

public class VietNamCustomer extends Customer {
    private String type;
    private Double quota;

    public VietNamCustomer() {
    }

    public VietNamCustomer(String idCustomer, String name, String type, Double quota) {
        super(idCustomer, name);
        this.type = type;
        this.quota = quota;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getQuota() {
        return quota;
    }

    public void setQuota(Double quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + type +
                ", quota: " + quota;
    }

    @Override
    public String getInfo() {
        return super.getIdCustomer() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                this.getType() + Comma.COMMA +
                this.getQuota() + Comma.COMMA + "\n";
    }
}
