package p08_Book_Store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stream<Book> books = Stream.of(
                new Book("Vinetu3", 20, "Karl Mai"),
                new Book("Vinetu1", 20, "Karl Mai"),
                new Book("Vinetu2", 15, "Karl Mai"),
                new Book("Sherlock Holmes", 12, "Arthur C. Doyl"),
                new Book("The Lost World", 43, "Arthur C. Doyl"),
                new Book("hunger Games", 150, "Suzan Colins"));


        books.collect(Collectors.groupingBy(Book::getAuthor,
                Collectors.summingDouble(Book::getPrice)))
                .entrySet()
                .stream()
                .sorted((x, y) -> {
                    int result = Double.compare(y.getValue(), x.getValue());
                    if (result == 0) {
                        return x.getKey().compareTo(y.getKey());
                    }
                    return result;
                }).forEach(author ->
            System.out.printf("%s=%.1f%n", author.getKey(), author.getValue())
        );

        System.out.println();
    }
}
