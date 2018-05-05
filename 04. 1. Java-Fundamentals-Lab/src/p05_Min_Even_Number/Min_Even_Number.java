package p05_Min_Even_Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Min_Even_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

        OptionalDouble min = tokens.stream()
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(x -> x % 2 == 0)
                .min();

        if (min.isPresent()) {
            System.out.printf("%.2f", min.getAsDouble());
        } else {
            System.out.println("No match");
        }

    }
}
