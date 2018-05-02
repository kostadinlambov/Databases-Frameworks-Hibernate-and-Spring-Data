package Part_3_Strings_Maps_and_Stream_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_Change_to_Uppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String changedText = input;

        Pattern pattern = Pattern.compile("<upcase>(.*?)<\\/upcase>");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
           changedText = changedText.replaceAll(matcher.group(), matcher.group(1).toUpperCase());
        }

        System.out.println(changedText);
    }
}
