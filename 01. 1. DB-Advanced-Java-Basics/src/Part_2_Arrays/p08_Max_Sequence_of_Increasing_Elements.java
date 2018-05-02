package Part_2_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p08_Max_Sequence_of_Increasing_Elements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 1;
        int maxCount = 1;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] < numbers[i+1]) {
                count++;
                if (count > maxCount) {
                    maxCount++;
                    endIndex = i+1;
                    startIndex = endIndex - maxCount +1;
                }
            } else {
                count = 1;
            }
        }

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(numbers[i] + " ");
        }




    }
}
