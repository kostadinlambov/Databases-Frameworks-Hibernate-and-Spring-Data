package p03_Last_Digit_Name;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputNum = Integer.parseInt(reader.readLine());
        Number number = new Number(inputNum);
        System.out.println(number.getNameOfLastDigit());
    }
}
