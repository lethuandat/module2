package bai_tap_them.quan_ly_nhan_vien_2.model;

//Muốn sử dụng comparable thì implements Comparable trong class muốn sắp xếp
//Ghi đè lại phương thức compareTo() rồi viết lại phương thức này
//Sắp xếp nhân viên theo lương tăng dần thì có thể dùng comparator hoặc comparable đều được
//Vì ở đây chỉ sắp xếp theo 1 tiêu chí, ta có thể dùng comparable cho gọn, không cần phải tạo thêm class như comparator

public abstract class Employee implements Comparable<Employee> {
    private String name;
    private String date;
    private String address;

    //2 constructor cùng tên nhưng khác tham số -> đa hình ở compile (cơ chế overloading)
    public Employee() {
    }

    public Employee(String name, String date, String address) {
        this.name = name;
        this.date = date;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
        return "name: " + name +
                ", date: " + date +
                ", address: " + address;
    }

    //Lớp cha nên có phương thức abstract getSalary để tính tiền lương
    //Nếu lớp cha không có, lớp con phải tự viết phương thức tính tiền lương -> tốn tài nguyên, ko tái sử dụng mã nguồn
    //Lớp con sẽ overriding lại, mỗi lớp con sẽ ghi đè lại theo cách khác nhau
    public abstract double getSalary();

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
