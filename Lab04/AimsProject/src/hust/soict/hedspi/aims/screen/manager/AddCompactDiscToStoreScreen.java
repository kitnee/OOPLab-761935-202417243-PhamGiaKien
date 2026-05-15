package hust.soict.hedspi.aims.screen.manager;

import javax.swing.JButton;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfTrackTitle;
    private JTextField tfTrackLength;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");

        tfTitle = addInputField("Title");
        tfCategory = addInputField("Category");
        tfCost = addInputField("Cost");
        tfDirector = addInputField("Director");
        tfArtist = addInputField("Artist");
        tfTrackTitle = addInputField("Track title");
        tfTrackLength = addInputField("Track length");

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> addCD());
        finishSetup(btnAdd);
    }

    private void addCD() {
        try {
            CompactDisc cd = new CompactDisc(
                    getNextMediaId(),
                    tfTitle.getText().trim(),
                    tfCategory.getText().trim(),
                    Float.parseFloat(tfCost.getText().trim()),
                    0,
                    tfDirector.getText().trim(),
                    tfArtist.getText().trim());

            String trackTitle = tfTrackTitle.getText().trim();
            if (!trackTitle.isEmpty()) {
                cd.addTrack(new Track(trackTitle, Integer.parseInt(tfTrackLength.getText().trim())));
            }

            store.addMedia(cd);
            showStore();
        } catch (NumberFormatException ex) {
            showError("Track length must be an integer. Cost must be a number.");
        }
    }
}
