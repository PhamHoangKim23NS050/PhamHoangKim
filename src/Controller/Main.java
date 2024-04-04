package Controller;

import View.BookView;

public class Main {
    public static void main(String[] args) {
        BookController controller = new BookController();
        BookView View = new BookView(controller);

        while (true) {
            View.displayMenu();
            View.processMenuChoice();
        }
    }
}