import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_Students_by_First_and_Last_Name {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            if ("End".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];

            if(firstName.compareTo(lastName) < 0) {
                System.out.println(firstName + " " + lastName);
            }
        }
    }
}

