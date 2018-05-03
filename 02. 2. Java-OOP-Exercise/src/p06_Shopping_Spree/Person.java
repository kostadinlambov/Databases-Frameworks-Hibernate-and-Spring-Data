package p06_Shopping_Spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<String> bagOfProducts;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.setBagOfProducts();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.equals("")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getMoney() {
        return this.money;
    }

    private void setMoney(int money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<String> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    private void setBagOfProducts() {
        this.bagOfProducts = new ArrayList<>();
    }

    public void buyProduct(String productName, int price){
        if(this.money - price < 0){
            System.out.printf("%s can't afford %s%n", this.name, productName);
        }else{
            this.money -= price;
            this.bagOfProducts.add(productName);
            System.out.printf("%s bought %s%n", this.name, productName);
        }
    }

    @Override
    public String toString() {
        if (this.bagOfProducts.size() > 0) {
            return this.name + " - " + this.bagOfProducts.toString().replaceAll("[\\[\\]]", "");
        } else {
           return String.format("%s – Nothing bought" ,this.name);
        }
    }
}
