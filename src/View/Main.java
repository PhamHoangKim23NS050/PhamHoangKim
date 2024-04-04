package View;

import Controller.BookController;

public class Main {
    public static void main(String[] args) {
        BookController controller = new BookController();
        BookView view = new BookView(controller);

        while (true) {
            view.displayMenu();
            view.processMenuChoice();
        }
    }
}