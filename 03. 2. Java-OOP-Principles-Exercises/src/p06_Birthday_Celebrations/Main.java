package p06_Birthday_Celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthday> birthdayList = new ArrayList<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("end".equalsIgnoreCase(tokens[0])) {
                break;
            }

            switch (tokens[0]) {
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthday = tokens[4];
                    Birthday citizen = new Citizen(name, age, id, birthday);
                    birthdayList.add(citizen);
                    break;
                case "Robot":
                    String model = tokens[1];
                    id = tokens[2];

                    Identifiable robot = new Robot(model, id);
                    //identifiableList.add(robot);
                    break;
                case "Pet":
                    name = tokens[1];
                    birthday = tokens[2];
                    Birthday pet = new Pet(name, birthday);
                    birthdayList.add(pet);
                    break;
            }
        }

        String yearToCheck = reader.readLine();

        for (Birthday element : birthdayList) {
            element.checkYear(yearToCheck);
        }
    }
}
