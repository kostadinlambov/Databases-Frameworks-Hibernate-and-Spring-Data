package Part_2_Arrays;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10_Index_of_Letters {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 97;
            System.out.println(input.charAt(i) + " -> " +  index);
        }
    }
}
