package ss05_access_modifier_static_method_static_property.bai_tap.student;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println(student1.getName() + " " + student1.getClasses());
        student1.setName("NamAnh");
        student1.setClasses("C0322");
        System.out.println(student1.getName() + " " + student1.getClasses());
    }
}
