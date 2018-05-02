package Part_1_Data_Types_and_Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Variable_in_Hexadecimal_Format {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int decimalNum = Integer.parseInt(input, 16);

        System.out.println(decimalNum);
    }
}
