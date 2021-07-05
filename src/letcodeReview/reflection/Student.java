package letcodeReview.reflection;

public class Student extends Person{
    public Student(String name) {
        super(name);
    }

    private int getGrade(int year) {
        return year;
    }


    public String getName() {
        return name;
    }
}
