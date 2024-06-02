import java.util.Scanner;

public class Main {
    private static BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n[1] Add book\n[2] Remove book\n[3] Update book\n[4] List books\n[5] Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter year of publication: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        bookManager.addBook(new Book(title, author, isbn, year));
        System.out.println("Book added successfully.");
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        bookManager.removeBook(isbn);
        System.out.println("Book removed successfully.");
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new year of publication: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Book updatedBook = new Book(title, author, isbn, year);
        bookManager.updateBook(isbn, updatedBook);
        System.out.println("Book updated successfully.");
    }

    private static void listBooks() {
        System.out.println("Listing all books:");
        for (Book book : bookManager.getBooks()) {
            System.out.printf("Title: %s, Author: %s, ISBN: %s, Year: %d%n",
                    book.getTitle(), book.getAuthor(), book.getIsbn(), book.getYear());
        }
    }
}
