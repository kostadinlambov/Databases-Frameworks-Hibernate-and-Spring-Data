package p07_Average_Grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentList = new ArrayList<>();

        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; i < number; i++) {
           String[] tokens = reader.readLine().split("\\s+");
           String name = tokens[0];
           Student student = new Student(name);

            for (int j = 1; j < tokens.length; j++) {
                student.addGradeToList(Double.parseDouble(tokens[j]));
            }
            studentList.add(student);
        }

        studentList.stream().sorted((a, b) -> {
            if(a.getName().compareTo(b.getName()) == 0){
                return Double.compare(b.averageGrade(), a.averageGrade());
            }
            return  a.getName().compareTo(b.getName());
        }).forEach(st -> {
            if(st.averageGrade() >= 5.00){
                System.out.printf("%s -> %.2f\n", st.getName(), st.averageGrade());
            }
        });
    }
}
