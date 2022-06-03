package bai_tap_them.quan_ly_tien_dien.model;

public class Check {
    private String idCheck;
    private String idCustomer;
    private String day;
    private Double quantity;
    private Double unitPrice;
    private Double totalMoney;

    public Check() {
    }

    public Check(String idCheck, String idCustomer, String day, Double quantity, Double unitPrice, Double totalMoney) {
        this.idCheck = idCheck;
        this.idCustomer = idCustomer;
        this.day = day;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalMoney = totalMoney;
    }

    public String getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(String idCheck) {
        this.idCheck = idCheck;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "idCheck: " + idCheck +
                ", idCustomer='" + idCustomer +
                ", day='" + day +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
