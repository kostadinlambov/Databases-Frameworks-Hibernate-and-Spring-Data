package p04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Callable call = new Smartphone();
        Browsable browse = new Smartphone();

        String[] numbers = reader.readLine().split("\\s+");
        String[] urls = reader.readLine().split("\\s+");

        Pattern numPattern = Pattern.compile("^\\d+$");
        Pattern urlPattern = Pattern.compile("^(\\D*)$");


        for (String number : numbers) {
            Matcher matcher = numPattern.matcher(number);
            boolean match = matcher.find();
            if(match){
               call.call(matcher.group(0));
            }else{
                System.out.println("Invalid number!");
            }
        }

        for (String url : urls) {
            Matcher matcher = urlPattern.matcher(url);
            boolean match = matcher.find();
            if(match){
                browse.browse(matcher.group(0));
            }else{
                System.out.println("Invalid URL!");
            }
        }
    }
}
