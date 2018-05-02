package Part_3_Strings_Maps_and_Stream_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p12_Reverse_String {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(reader.readLine()).reverse();
        System.out.println(sb);
    }
}
