package p10_Group_by_Group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];
            String fullName = firstName + " " + lastName;
            Integer group = Integer.parseInt(tokens[2]);


            Person person = new Person(fullName, group);

            personList.add(person);
        }

        Map<Integer, List<Person>> groupByGroupMap = personList.stream()
                .collect(Collectors.groupingBy(x -> x.getGroup()));

        groupByGroupMap.entrySet().stream()
                .forEach(group -> {

                    String namesCollection = group.getValue()
                            .stream()
                            .map(x -> x.getName())
                            .collect(Collectors.joining(", "));

                    System.out.println(group.getKey()+ " - " + namesCollection);
                });
    }
}
