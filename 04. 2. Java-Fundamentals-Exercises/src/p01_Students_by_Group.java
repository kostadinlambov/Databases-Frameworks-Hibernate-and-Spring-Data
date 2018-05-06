import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class p01_Students_by_Group {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> studentsMap = new TreeMap<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            if ("End".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];
            int groupNumber = Integer.parseInt(tokens[2]);

            if (groupNumber == 2) {
                if (!studentsMap.containsKey(firstName)) {
                    studentsMap.put(firstName, new ArrayList<>());
                }
                studentsMap.get(firstName).add(lastName);
            }
        }

        studentsMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(st -> {
                    st.getValue()
                            .forEach(lastName -> {
                                System.out.println(st.getKey() + " " + lastName);
                            });

                });
    }
}
