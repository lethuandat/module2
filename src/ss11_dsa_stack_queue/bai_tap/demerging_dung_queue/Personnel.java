package ss11_dsa_stack_queue.bai_tap.demerging_dung_queue;

public class Personnel implements Comparable<Personnel> {
    private String name;
    private String gender;
    private int year;

    public Personnel() {
    }

    public Personnel(String name, String gender, int year) {
        this.name = name;
        this.gender = gender;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Personnel o) {
        if (this.getYear() > o.getYear()) {
            return 1;
        } else if (this.getYear() < o.getYear()) {
            return -1;
        } else {
            return 1;
        }
    }
}
