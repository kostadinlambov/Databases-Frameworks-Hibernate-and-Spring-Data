package Part_3_Strings_Maps_and_Stream_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class p14_Censor_Email_Address {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String email = reader.readLine();
        String text = reader.readLine();

        int index = email.indexOf("@");
        String stars = String.join("", (Collections.nCopies(index, "*")));
        String censoredEmail = stars + email.substring(index);

        System.out.println(text.replaceAll(email, censoredEmail));
    }
}
