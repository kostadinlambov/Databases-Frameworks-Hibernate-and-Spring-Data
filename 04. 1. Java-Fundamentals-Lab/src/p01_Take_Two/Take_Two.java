package p01_Take_Two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Take_Two {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        Integer[] numbers = new Integer[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.valueOf(tokens[i]);
        }

        Arrays.stream(numbers)
                .filter(x -> x >= 10 && x <= 20)
                .distinct()
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
