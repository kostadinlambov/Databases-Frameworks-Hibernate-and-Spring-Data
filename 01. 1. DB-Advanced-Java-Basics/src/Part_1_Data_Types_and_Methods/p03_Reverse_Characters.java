package Part_1_Data_Types_and_Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_Reverse_Characters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String firstChar = reader.readLine();
        String secondChar = reader.readLine();
        String thirdChar = reader.readLine();

        sb.append(firstChar).append(secondChar).append(thirdChar);

        System.out.println(sb.reverse());
    }
}
