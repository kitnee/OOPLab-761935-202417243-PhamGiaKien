package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel inputPanel;

    public AddItemToStoreScreen(Store store, String screenTitle) {
        this.store = store;
        this.inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        this.inputPanel.setBorder(new EmptyBorder(20, 30, 20, 30));

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createMenuBar(), BorderLayout.NORTH);

        setTitle(screenTitle);
        setSize(600, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected JTextField addInputField(String label) {
        JTextField textField = new JTextField();
        inputPanel.add(new JLabel(label));
        inputPanel.add(textField);
        return textField;
    }

    protected void finishSetup(JButton btnAdd) {
        JPanel actionPanel = new JPanel();
        actionPanel.add(btnAdd);

        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(actionPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu updateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });
        updateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });
        updateStore.add(addCD);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });
        updateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> showStore());

        menu.add(updateStore);
        menu.add(viewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    protected void showStore() {
        new StoreManagerScreen(store);
        dispose();
    }

    protected int getNextMediaId() {
        int maxId = 0;
        for (Media media : store.getItemsInStore()) {
            if (media.getId() > maxId) {
                maxId = media.getId();
            }
        }
        return maxId + 1;
    }

    protected void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Invalid input", JOptionPane.ERROR_MESSAGE);
    }
}
