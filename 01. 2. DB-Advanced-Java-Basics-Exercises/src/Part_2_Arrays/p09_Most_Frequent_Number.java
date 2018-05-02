package Part_2_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class p09_Most_Frequent_Number {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> numbersMap = new LinkedHashMap<>();

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            if(!numbersMap.containsKey(numbers[i])){
                numbersMap.put(numbers[i], 0);
            }

            numbersMap.put(numbers[i], numbersMap.get(numbers[i])+1);
        }

        final int[] count = {1};
        numbersMap.entrySet().stream()
                .sorted((x,y) -> Integer.compare(y.getValue(), x.getValue()))
                .forEach(number -> {
                    if(count[0] == 1){
                      //  System.out.println(number.getKey());
                        System.out.printf("The number %d is the most frequent (occurs %d times)%n", number.getKey(), number.getValue());
                    }
                    count[0]++;
                });
    }
}
