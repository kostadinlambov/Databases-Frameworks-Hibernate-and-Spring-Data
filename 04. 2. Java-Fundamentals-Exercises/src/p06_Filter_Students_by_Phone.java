import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p06_Filter_Students_by_Phone {
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
            String phone = tokens[2];
            String fullName = firstName + " " + lastName;

            studentsMap.putIfAbsent(fullName, phone);
        }

        studentsMap.entrySet().stream()
                .filter(x -> x.getValue().startsWith("02") || x.getValue().startsWith("+3592"))
                .forEach(st -> System.out.println(st.getKey()));
    }
}





