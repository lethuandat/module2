package bai_tap_them.quan_ly_nhan_vien;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static Person[] persons = new Person[20];

    static String name = null;
    static int age = 0;
    static boolean gender = false;
    static double salary = 0.0;
    static double point = 0.0;

    static {
        persons[0] = new Teacher(1, "Lê Văn An", 30, true, 10000000);
        persons[1] = new Teacher(2, "Trần Thị Thư", 28, false, 8000000);
        persons[2] = new Student(3, "Nguyễn Ngọc Đại", 22, true, 64);
        persons[3] = new Student(4, "Đỗ Văn Tâm", 20, false, 75);
        persons[4] = new Student(5, "Lê Thị Như", 21, false, 88);
    }

    public static void displayPerson() {
        for (Person value : persons) {
            if (value != null) {
                System.out.println(value);
            }
        }
        System.out.println("List person: " + Person.count + " persons.");
    }

    public static void addNewPerson() {
        if (Person.count >= persons.length) {
            System.out.println("Full list, can not add.");
        } else {
            System.out.println("Are you want add teacher or student ?");
            System.out.println("1. Add new teacher");
            System.out.println("2. Add new student");

            System.out.println("Choose option, please!\nChoose = ");
            int choose = Integer.parseInt(input.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("Enter teacher name: ");
                    name = input.nextLine();
                    System.out.println("Enter teacher age: ");
                    age = Integer.parseInt(input.nextLine());
                    System.out.println("Enter gender: ");
                    gender = Boolean.parseBoolean(input.nextLine());
                    System.out.println("Enter salary: ");
                    salary = Double.parseDouble(input.nextLine());

                    Person newPerson = new Teacher(Person.count + 1, name, age, gender, salary);
                    persons[Person.count - 1] = newPerson;
                    break;
                case 2:
                    System.out.println("Enter student name: ");
                    name = input.nextLine();
                    System.out.println("Enter student age: ");
                    age = Integer.parseInt(input.nextLine());
                    System.out.println("Enter gender: ");
                    gender = Boolean.parseBoolean(input.nextLine());
                    System.out.println("Enter point: ");
                    point = Double.parseDouble(input.nextLine());

                    Person newStudent = new Student(Person.count + 1, name, age, gender, point);
                    persons[Person.count - 1] = newStudent;
                    break;
                default:
                    System.out.println("Input choose incorrect.");
            }
        }
    }

    public static void updatePerson() {
        System.out.println("Enter ID person want update: ");
        int idUpdate = Integer.parseInt(input.nextLine());
        boolean check = false;
        int indexPerson = 0;

        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && persons[i].getId() == idUpdate) {
                check = true;
                indexPerson = i;
                break;
            }
        }

        if (check) {
            if (persons[indexPerson] instanceof Teacher) {
                Teacher newTeacher = (Teacher) persons[indexPerson];
                System.out.println("Enter teacher name: ");
                name = input.nextLine();
                System.out.println("Enter teacher age: ");
                age = Integer.parseInt(input.nextLine());
                System.out.println("Enter gender: ");
                gender = Boolean.parseBoolean(input.nextLine());
                System.out.println("Enter salary: ");
                salary = Double.parseDouble(input.nextLine());

                newTeacher.setName(name);
                newTeacher.setAge(age);
                newTeacher.setGender(gender);
                newTeacher.setSalary(salary);

                System.out.println("Update OK");
            } else {
                Student newStudent = (Student) persons[indexPerson];
                System.out.println("Enter student name: ");
                name = input.nextLine();
                System.out.println("Enter student age: ");
                age = Integer.parseInt(input.nextLine());
                System.out.println("Enter gender: ");
                gender = Boolean.parseBoolean(input.nextLine());
                System.out.println("Enter point: ");
                point = Double.parseDouble(input.nextLine());

                newStudent.setName(name);
                newStudent.setAge(age);
                newStudent.setGender(gender);
                newStudent.setPoint(point);

                System.out.println("Update OK");
            }
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    public static void deletePerson() {
        System.out.println("Enter ID person want delete: ");
        int idDelete = Integer.parseInt(input.nextLine());
        boolean check = false;
        int indexPerson = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && persons[i].getId() == idDelete) {
                check = true;
                indexPerson = i;
                break;
            }
        }

        if (check) {
            persons[indexPerson] = null;
            System.out.println("Delete OK.");
            Person.count -= 1;
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    public static void searchPerson() {
        System.out.println("Enter anything want to search: ");
        String strSearch = input.nextLine();
        int countPersonSearch = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && persons[i].getName().contains(strSearch)) {
                System.out.println(persons[i]);
                countPersonSearch++;
            }
        }
        System.out.println(countPersonSearch + " results found.");
    }

    public static void main(String[] args) {
        do {
            System.out.println("----------Person Management----------");
            System.out.println("1. Display list person");
            System.out.println("2. Add new person");
            System.out.println("3. Update person");
            System.out.println("4. Delete person");
            System.out.println("5. Search person");
            System.out.println("6. Exit");

            System.out.println("Choose option, please!\nChoose = ");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("----------List Person----------");
                    displayPerson();
                    break;
                case 2:
                    System.out.println("----------Add New Person----------");
                    addNewPerson();
                    break;
                case 3:
                    System.out.println("----------Update Person----------");
                    updatePerson();
                    break;
                case 4:
                    System.out.println("----------Delete Person----------");
                    deletePerson();
                    break;
                case 5:
                    System.out.println("----------Search Person----------");
                    searchPerson();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Input choose incorrect.");
            }
        } while (true);
    }
}
