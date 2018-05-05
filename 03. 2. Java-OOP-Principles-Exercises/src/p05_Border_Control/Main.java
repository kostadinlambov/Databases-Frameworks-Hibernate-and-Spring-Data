package p05_Border_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> identifiableList = new ArrayList<>();

        while(true){
            String[] tokens = reader.readLine().split("\\s+");

            if("end".equalsIgnoreCase(tokens[0])){
                break;
            }

            if(tokens.length == 3){
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Identifiable citizen = new Citizen(name, age, id);

                identifiableList.add(citizen);
            }else{
                String model = tokens[0];
                String id = tokens[1];

                Identifiable robot = new Robot(model, id);
                identifiableList.add(robot);
            }
        }

        String fakeId = reader.readLine();

        for (Identifiable element : identifiableList) {
            element.checkId(fakeId);
        }
    }
}
