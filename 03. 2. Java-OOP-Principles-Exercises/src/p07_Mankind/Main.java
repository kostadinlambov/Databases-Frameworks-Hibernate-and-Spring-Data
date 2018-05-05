package p07_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentInput = reader.readLine().split("\\s+");
        String firstNameStudent = studentInput[0];
        String lastNameStudent = studentInput[1];
        String facultyNumber = studentInput[2];

        String[] workerInput = reader.readLine().split("\\s+");
        String firstName = workerInput[0];
        String lastName = workerInput[1];
        double salary = Double.parseDouble(workerInput[2]);
        double workingHours = Double.parseDouble(workerInput[3]);

        try{
            Human student = new Student(firstNameStudent, lastNameStudent, facultyNumber);
            Human worker = new Worker(firstName, lastName, salary,workingHours);
            System.out.println(student.toString());
            System.out.println(worker.toString());
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
