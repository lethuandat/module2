package ss05_access_modifier_static_method_static_property.thuc_hanh;

public class StaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        s1.display();
        s2.display();
        s3.display();
    }

    public static class Student {
        private int rollNo;
        private String name;
        static String college = "BBDIT";

        Student(int r, String n) {
            rollNo = r;
            name = n;
        }

        static void change() {
            college = "CODEGYM";
        }

        void display() {
            System.out.println(rollNo + " " + name + " " + college);
        }
    }
}


