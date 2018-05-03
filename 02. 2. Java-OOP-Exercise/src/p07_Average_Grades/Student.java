package p07_Average_Grades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private List<Double> listOfGrades;

    public Student(String name) {
        this.setName(name);
        this.setListOfGrades();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Double> getListOfGrades() {
        return Collections.unmodifiableList(this.listOfGrades);
    }

    private void setListOfGrades() {
        this.listOfGrades = new ArrayList<>();
    }

    public void addGradeToList(Double grade){
        this.listOfGrades.add(grade);
    }

    public double averageGrade(){
        return listOfGrades.stream().mapToDouble(g -> g).average().orElse(0.0);

    }
}
