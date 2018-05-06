import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p07_Excellent_Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> studentsMap = new LinkedHashMap<>();

        while (true) {
            List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

            if ("END".equalsIgnoreCase(tokens.get(0))) {
                break;
            }

            String firstName = tokens.get(0);
            String lastName = tokens.get(1);
            String fullName = firstName + " " + lastName;

            List<Integer> markList = tokens.subList(2, tokens.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            studentsMap.putIfAbsent(fullName, new ArrayList<>());

            studentsMap.get(fullName).addAll(markList);
        }

        studentsMap.entrySet().stream()
                .filter(x -> x.getValue().contains(6))
                .forEach(st -> System.out.println(st.getKey()));
    }
}
