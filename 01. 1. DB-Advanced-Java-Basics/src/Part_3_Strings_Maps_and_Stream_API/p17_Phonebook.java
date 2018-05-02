package Part_3_Strings_Maps_and_Stream_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p17_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phoneBook = new LinkedHashMap<>();
        String[] input = reader.readLine().split("\\s+");

        while (true) {
            if ("END".equalsIgnoreCase(input[0])) {
                break;
            }

            switch (input[0]) {
                case "A":
                    String name = input[1];
                    String phone = input[2];
                    phoneBook.put(name, phone);
                    break;
                case "S":
                    name = input[1];
                    if (phoneBook.containsKey(name)) {
                        phone = phoneBook.get(name);
                        System.out.println(name + " -> " + phone);
                    }else{
                        System.out.printf("Contact %s does not exist.\n", name);
                    }
                    break;
            }

            input = reader.readLine().split("\\s+");
        }

    }
}
