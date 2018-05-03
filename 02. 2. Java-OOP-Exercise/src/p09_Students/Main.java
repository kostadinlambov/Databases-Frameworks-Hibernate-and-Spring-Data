package p09_Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String line = reader.readLine();
            if("END".equalsIgnoreCase(line)){
                break;
            }
            Student student = new Student(line);
        }

        System.out.println(Student.counter);
    }
}
