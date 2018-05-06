import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p05_Filter_Students_by_Email_Domain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> studentsMap = new LinkedHashMap<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];
            String email = tokens[2];
            String fullName = firstName + " " + lastName;

            studentsMap.putIfAbsent(fullName, email);
        }

        studentsMap.entrySet().stream()
                .filter(x -> x.getValue().endsWith("@gmail.com"))
                .forEach(st -> System.out.println(st.getKey()));
    }
}
