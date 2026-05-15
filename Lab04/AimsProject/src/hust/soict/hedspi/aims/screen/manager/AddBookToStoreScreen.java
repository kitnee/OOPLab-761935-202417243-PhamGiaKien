package hust.soict.hedspi.aims.screen.manager;

import javax.swing.JButton;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");

        tfTitle = addInputField("Title");
        tfCategory = addInputField("Category");
        tfCost = addInputField("Cost");
        tfAuthors = addInputField("Authors (separated by comma)");

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> addBook());
        finishSetup(btnAdd);
    }

    private void addBook() {
        try {
            Book book = new Book(
                    getNextMediaId(),
                    tfTitle.getText().trim(),
                    tfCategory.getText().trim(),
                    Float.parseFloat(tfCost.getText().trim()));

            for (String author : tfAuthors.getText().split(",")) {
                String trimmedAuthor = author.trim();
                if (!trimmedAuthor.isEmpty()) {
                    book.addAuthor(trimmedAuthor);
                }
            }

            store.addMedia(book);
            showStore();
        } catch (NumberFormatException ex) {
            showError("Cost must be a number.");
        }
    }
}
