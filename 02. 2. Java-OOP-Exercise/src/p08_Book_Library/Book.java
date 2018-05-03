package p08_Book_Library;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String releaseDate;
    private String ISBN;
    private Double price;

    public Book(String title, String author, String publisher, String releaseDate, String ISBN, Double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setReleaseDate(releaseDate);
        this.setISBN(ISBN);
        this.setPrice(price);
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
