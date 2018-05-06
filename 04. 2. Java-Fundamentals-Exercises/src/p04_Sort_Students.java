import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p04_Sort_Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentsList = new ArrayList<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];
            String fullName = firstName + " " + lastName;

            studentsList.add(fullName);
        }

        studentsList.stream().sorted((x, y) -> {
            String[] xTokens = x.split("\\s+");
            String[] yTokens = y.split("\\s+");

            int result = xTokens[1].compareTo(yTokens[1]);

            if (result == 0) {
                return yTokens[0].compareTo(xTokens[0]);

            }
            return result;
        }).forEach(System.out::println);

    }
}
