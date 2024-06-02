import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookManager implements BookOperations {
    private List<Book> books = new ArrayList<>();

    public BookManager() {
        // Dodajemy przykładowe książki
        books.add(new Book("Book One", "Author One", "ISBN001", 2001));
        books.add(new Book("Book Two", "Author Two", "ISBN002", 2002));
        books.add(new Book("Book Three", "Author Three", "ISBN003", 2003));
        books.add(new Book("Book Four", "Author Four", "ISBN004", 2004));
        books.add(new Book("Book Five", "Author Five", "ISBN005", 2005));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    @Override
    public void updateBook(String isbn, Book updatedBook) {
        Optional<Book> bookOptional = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
        bookOptional.ifPresent(book -> {
            books.remove(book);
            books.add(updatedBook);
        });
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
