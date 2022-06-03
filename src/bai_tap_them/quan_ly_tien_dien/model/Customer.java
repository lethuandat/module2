package bai_tap_them.quan_ly_tien_dien.model;

public abstract class Customer {
    private String idCustomer;
    private String name;

    public Customer() {
    }

    public Customer(String idCustomer, String name) {
        this.idCustomer = idCustomer;
        this.name = name;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID Customer: " + idCustomer +
                ", name: " + name;
    }

    public abstract String getInfo();
}
