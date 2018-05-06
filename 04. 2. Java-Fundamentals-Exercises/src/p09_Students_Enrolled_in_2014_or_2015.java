import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p09_Students_Enrolled_in_2014_or_2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> studentsMap = new LinkedHashMap<>();

        while (true) {
            List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

            if ("END".equalsIgnoreCase(tokens.get(0))) {
                break;
            }

            String facultyNumber = tokens.get(0);

            List<Integer> markList = tokens.subList(1, tokens.size())
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            studentsMap.putIfAbsent(facultyNumber, new ArrayList<>());
            studentsMap.get(facultyNumber).addAll(markList);
        }

        studentsMap.entrySet().stream()
                .filter(st -> st.getKey().endsWith("14") || st.getKey().endsWith("15"))
                .forEach(st ->
                        System.out.println(st.getValue().toString().replaceAll("[\\[\\],]", "")));
    }

}