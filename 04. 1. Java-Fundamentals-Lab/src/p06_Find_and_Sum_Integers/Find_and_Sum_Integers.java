package p06_Find_and_Sum_Integers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Find_and_Sum_Integers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));


        Optional<Integer> sum = tokens.stream()
                .filter(x -> isNum(x))
                .map(x -> Integer.valueOf(x))
                .reduce((x, y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNum(String string) {

        if(string.isEmpty()){
            return false;
        }

        char[] characters = string.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if(i == 0){
                if(characters[i] == '-' || characters[i] == '+'){
                    continue;
                }
            }

            if(!Character.isDigit(characters[i])){
                return false;
            }
        }

        return true;
    }
}
