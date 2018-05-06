import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p03_Students_by_Age {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> studentsMap = new LinkedHashMap<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String name = tokens[0] + " " + tokens[1];
            int age = Integer.parseInt(tokens[2]);

            studentsMap.putIfAbsent(name, age);
        }

        studentsMap.entrySet().stream()
                .filter(x -> x.getValue() >= 18 && x.getValue() <= 24)
                .forEach(st -> System.out.println(st.getKey() + " " + st.getValue()));
    }
}
