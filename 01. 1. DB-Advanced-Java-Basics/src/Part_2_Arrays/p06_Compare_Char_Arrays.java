package Part_2_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p06_Compare_Char_Arrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstString = reader.readLine().replaceAll("\\s", "");
        String secondString = reader.readLine().replaceAll("\\s", "");

        if(firstString.compareTo(secondString) <= 0){
            System.out.println(firstString);
            System.out.println(secondString);
        }else{
            System.out.println(secondString);
            System.out.println(firstString);
        }

    }
}
