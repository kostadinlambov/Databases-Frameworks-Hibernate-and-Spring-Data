package p08_Book_Store;

public class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, double price, String author) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
