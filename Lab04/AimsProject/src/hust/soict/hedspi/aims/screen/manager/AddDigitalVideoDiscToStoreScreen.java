package hust.soict.hedspi.aims.screen.manager;

import javax.swing.JButton;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");

        tfTitle = addInputField("Title");
        tfCategory = addInputField("Category");
        tfDirector = addInputField("Director");
        tfLength = addInputField("Length");
        tfCost = addInputField("Cost");

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> addDVD());
        finishSetup(btnAdd);
    }

    private void addDVD() {
        try {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    getNextMediaId(),
                    tfTitle.getText().trim(),
                    tfCategory.getText().trim(),
                    tfDirector.getText().trim(),
                    Integer.parseInt(tfLength.getText().trim()),
                    Float.parseFloat(tfCost.getText().trim()));

            store.addMedia(dvd);
            showStore();
        } catch (NumberFormatException ex) {
            showError("Length must be an integer and cost must be a number.");
        }
    }
}
