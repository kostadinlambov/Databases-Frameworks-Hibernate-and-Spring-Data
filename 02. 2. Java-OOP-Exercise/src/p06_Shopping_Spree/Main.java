package p06_Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        String[] personsInput = reader.readLine().split(";");

        for (String currentPerson : personsInput) {
            String[] tokens = currentPerson.split("=");
            String name = tokens[0];
            int money = Integer.parseInt(tokens[1]);
            try{
                Person person = new Person(name, money);
                personList.add(person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String[] productsInput = reader.readLine().split(";");

        for (String currentProduct : productsInput) {

            String[] tokens = currentProduct.split("=");
            String name = tokens[0];
            int price = Integer.parseInt(tokens[1]);

            try{
                Product product = new Product(name, price);
                productList.add(product);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        while (true) {
            String[] token = reader.readLine().split("\\s+");
            if("END".equalsIgnoreCase(token[0])){
                break;
            }

            String personName = token[0];
            String productName = token[1];
            final int[] productPrice = {0};

            productList.stream()
                    .filter(x -> x.getName().equals(productName))
                    .forEach(product ->{
                            productPrice[0] =   product.getCost();
                    });


            personList.stream()
                    .filter(x -> x.getName().equals(personName))
                    .forEach(element -> {
                       element.buyProduct(productName, productPrice[0]);
                    });

        }

        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
