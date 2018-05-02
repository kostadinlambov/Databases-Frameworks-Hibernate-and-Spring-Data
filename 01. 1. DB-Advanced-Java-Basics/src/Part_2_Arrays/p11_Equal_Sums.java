package Part_2_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11_Equal_Sums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < numbers.length; i++) {

            int leftSum = calculateLeftSum(i, numbers);
            int rightSum = calculateRightSum(i, numbers);

            if(leftSum == rightSum){
                System.out.println(i);
                return;
            }
        }

        System.out.println("no");
    }

    private static int calculateRightSum(int index, int[] numbers) {
        int sum = 0;
        for (int i = index+1; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    private static int calculateLeftSum(int index, int[] numbers) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}



