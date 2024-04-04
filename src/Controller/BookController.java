package Controller;


import Model.Book;
import View.BookView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookController {
    private List<Book> books;
    private Scanner scanner;

    public BookController() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.println("Enter the book details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        Book book = new Book(title, author, genre);
        books.add(book);
    }

    public void removeBook() {
        System.out.println("Enter the title of the book to remove: ");
        String title = scanner.nextLine();

        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void showAllBooks() {
        System.out.println("All books:");
        books.forEach(System.out::println);
    }

    public void saveBooksToFile(String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(books);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadBooksFromFile(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            books = (List<Book>) inputStream.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public void exploreDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        exploreDirectoryRecursive(directory);
    }

    private void exploreDirectoryRecursive(File directory) {
        if (directory.isDirectory()) {
            System.out.println("Directory: " + directory.getAbsolutePath());
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        exploreDirectoryRecursive(file);
                    } else {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
