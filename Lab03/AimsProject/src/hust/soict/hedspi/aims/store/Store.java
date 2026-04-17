package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
    public ArrayList<Media> getItemsInStore() { 
    	return itemsInStore; 
    }
    
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added '" + media.getTitle() + "' to store.");
        } else {
            System.out.println("Media is already in store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Deleted '" + media.getTitle() + "' out of store.");
        } else {
            System.out.println("Can not find '" + media.getTitle() + "' to delete");
        }
    }
}