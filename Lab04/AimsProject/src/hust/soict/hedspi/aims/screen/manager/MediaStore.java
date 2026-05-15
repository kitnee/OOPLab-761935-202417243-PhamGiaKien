package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel title = new JLabel(media.getTitle(), SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.setAlignmentX(CENTER_ALIGNMENT);
            btnPlay.addActionListener(e -> playMedia());
            container.add(btnPlay);
        }
        
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
    }

    private void playMedia() {
        ((Playable) media).play();

        Window owner = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog(owner, "Play", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(new BorderLayout());

        JTextArea message = new JTextArea("Playing media:\n" + media.getTitle());
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setBorder(new EmptyBorder(16, 16, 16, 16));
        dialog.add(message, BorderLayout.CENTER);

        JButton btnClose = new JButton("OK");
        btnClose.addActionListener(e -> dialog.dispose());
        JPanel actions = new JPanel();
        actions.add(btnClose);
        dialog.add(actions, BorderLayout.SOUTH);

        dialog.setSize(280, 160);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
