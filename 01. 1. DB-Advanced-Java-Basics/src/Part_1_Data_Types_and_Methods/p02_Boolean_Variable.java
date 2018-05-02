package Part_1_Data_Types_and_Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_Boolean_Variable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if(input.equalsIgnoreCase("True")){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
