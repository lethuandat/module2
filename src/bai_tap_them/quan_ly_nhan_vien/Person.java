package bai_tap_them.quan_ly_nhan_vien;

public abstract class Person {
    private int id;
    private String name;
    private int age;
    private boolean gender;
    public static int count = 0;

    public Person() {
    }

    public Person(int id, String name, int age, boolean gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ID = " + id +
                ", name = " + name +
                ", age = " + age +
                ", gender = " + (isGender() ? "nam" : "nữ");
    }
}
