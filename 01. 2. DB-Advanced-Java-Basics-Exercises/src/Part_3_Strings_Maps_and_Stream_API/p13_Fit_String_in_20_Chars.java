package Part_3_Strings_Maps_and_Stream_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;

public class p13_Fit_String_in_20_Chars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        if(input.length() >= 20){
            System.out.println(input.substring(0,20));
        }else{
            int length = 20 -input.length();
            String stars = String.join("", (Collections.nCopies(length, "*")));
            System.out.println(input + stars);
        }
    }
}
