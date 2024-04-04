package View;
import java.util.List;

import Model.Book;

import java.util.List;
import java.util.Scanner;
import Controller.BookController;
public class BookView {
    private BookController controller;
    private Scanner scanner;

    public BookView(BookController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("===== Book Management =====");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Show all books");
        System.out.println("4. Save books to file");
        System.out.println("5. Load books from file");
        System.out.println("6. Explore directory");
        System.out.println("0. Exit");
        System.out.println("===========================");
        System.out.print("Enter your choice: ");
    }

    public void processMenuChoice() {
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                controller.addBook();
                break;
            case 2:
                controller.removeBook();
                break;
            case 3:
                controller.showAllBooks();
                break;
            case 4:
                System.out.print("Enter file path: ");
                String saveFilePath = scanner.nextLine();
                controller.saveBooksToFile(saveFilePath);
                break;
            case 5:
                System.out.print("Enter file path: ");
                String loadFilePath = scanner.nextLine();
                controller.loadBooksFromFile(loadFilePath);
                break;
            case 6:
                System.out.print("Enter directory path: ");
                String directoryPath = scanner.nextLine();
                controller.exploreDirectory(directoryPath);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}