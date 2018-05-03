package p06_Shopping_Spree;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
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

    public int getCost() {
        return this.cost;
    }

    private void setCost(int cost) {
        this.cost = cost;
    }
}
