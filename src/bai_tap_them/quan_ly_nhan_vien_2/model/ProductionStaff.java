package bai_tap_them.quan_ly_nhan_vien_2.model;

import bai_tap_them.quan_ly_nhan_vien_2.service.IEmployeeService;

import java.math.BigDecimal;

public class ProductionStaff extends Employee implements IEmployeeService {
    private int numbersProduct;

    //2 constructor cùng tên nhưng khác tham số -> đa hình ở compile (cơ chế overloading)
    public ProductionStaff() {
    }

    public ProductionStaff(String name, String date, String address, int numbersProduct) {
        super(name, date, address);
        this.numbersProduct = numbersProduct;
    }

    public int getNumbersProduct() {
        return numbersProduct;
    }

    public void setNumbersProduct(int numbersProduct) {
        this.numbersProduct = numbersProduct;
    }

    @Override
    public String toString() {
        return "ProductionStaff " +
                super.toString() +
                ", numbersProduct: " +
                numbersProduct +
                ", salary: " + new BigDecimal(getSalary());
    }

    //overriding phương thức getSalary() của lớp cha, đa hình ở runtime, khi chạy
    @Override
    public double getSalary() {
        return 120000 * numbersProduct;
    }

    @Override
    public String keepingTime() {
        return "Đã chấm công";
    }
}
