package p10_Beer_Counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] input = reader.readLine().split(" ");

            if("End".equalsIgnoreCase(input[0])){
                break;
            }

            int beerToBuy = Integer.parseInt(input[0]);
            int beerToDrink = Integer.parseInt(input[0]);

            buyBeer(beerToBuy);
            drinkBeer(beerToDrink);
        }

        System.out.println(BeerCounter.beerInStock + " " +  BeerCounter.beersDrankCount);
    }

    public static void drinkBeer(int bottlesCount) {
        BeerCounter.beerInStock -=  bottlesCount;
        BeerCounter.beersDrankCount +=  bottlesCount;
    }


    public static void buyBeer(int bottlesCount){
        BeerCounter.beerInStock += bottlesCount;
    }
}
