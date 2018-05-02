package Part_1_Data_Types_and_Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p05_Integer_to_Hex_and_Binary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int decimal = Integer.parseInt(reader.readLine());

        String hexadecimal = String.format("%X", decimal);
        String binaryNum = Integer.toBinaryString(decimal);

        System.out.println(hexadecimal);
        System.out.println(binaryNum);
    }
}
