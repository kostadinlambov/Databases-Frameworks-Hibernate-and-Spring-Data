package Part_1_Data_Types_and_Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_Vowel_or_Digit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if ("aeouiAEOIU".contains(input)) {
            System.out.println("vowel");
        } else if (Character.isDigit(input.charAt(0))) {
            System.out.println("digit");
        } else {
            System.out.println("other");
        }
    }
}
