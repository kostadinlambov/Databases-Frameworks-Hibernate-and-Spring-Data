package p09_Students;

public class Student {

    public static Integer counter = 0;
    private String name;


    public Student(String name) {
        this.name = name;
        counter++;
    }
}
