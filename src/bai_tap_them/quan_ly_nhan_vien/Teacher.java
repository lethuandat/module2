package bai_tap_them.quan_ly_nhan_vien;

public class Teacher extends Person{
    private double salary;

    public Teacher() {
    }

    public Teacher(double salary) {
        this.salary = salary;
    }

    public Teacher(int id, String name, int age, boolean gender, double salary) {
        super(id, name, age, gender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", teacher " +
                ", salary = " + salary;
    }
}
