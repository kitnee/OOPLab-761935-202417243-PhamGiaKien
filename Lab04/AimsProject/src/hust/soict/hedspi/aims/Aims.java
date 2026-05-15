package hust.soict.hedspi.aims;

import java.util.Scanner;
import java.util.Collections;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initStore();
        
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: 
                    System.out.println("Goodbye!");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nStore Menu: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nMedia Details: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nCart Menu: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void viewStore() {
        for (Media m : store.getItemsInStore()) {
            System.out.println(m.toString());
        }

        int choice;
        while (true) {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media found = findMediaInStore(title);
                    if (found != null) {
                        System.out.println(found.toString());
                        handleMediaDetails(found);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2:
                    System.out.print("Enter media title: ");
                    String tAdd = scanner.nextLine();
                    Media mAdd = findMediaInStore(tAdd);
                    if (mAdd != null) cart.addMedia(mAdd);
                    else System.out.println("Media not found!");
                    break;
                case 3:
                    System.out.print("Enter media title: ");
                    String tPlay = scanner.nextLine();
                    Media mPlay = findMediaInStore(tPlay);
                    if (mPlay instanceof Playable) ((Playable) mPlay).play();
                    else System.out.println("This media cannot be played.");
                    break;
                case 4: viewCart(); break;
            }
        }
    }

    public static void handleMediaDetails(Media media) {
        int choice;
        while (true) {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice == 1) cart.addMedia(media);
            else if (choice == 2) {
                if (media instanceof Playable) ((Playable) media).play();
                else System.out.println("This media cannot be played.");
            }
        }
    }

    public static void viewCart() {
        int choice;
        while (true) {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("1. By ID / 2. By Title");
                    int fType = scanner.nextInt(); scanner.nextLine();
                    if (fType == 1) {
                        System.out.print("Enter ID: "); cart.searchById(scanner.nextInt());
                    } else {
                        System.out.print("Enter Title: "); cart.searchByTitle(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Options: ");
                    System.out.println("1. Sort by Title then Cost");
                    System.out.println("2. Sort by Cost then Title");
                    System.out.print("Please choose: ");
                    int sType = scanner.nextInt();
                    scanner.nextLine();

                    if (sType == 1) {
                        cart.sortByTitle();
                        System.out.println("Cart sorted by Title.");
                    } else if (sType == 2) {
                        cart.sortByCost();
                        System.out.println("Cart sorted by Cost.");
                    } else {
                        System.out.println("Invalid option.");
                    }
                    cart.print(); 
                    break;

                case 3:
                    System.out.print("Enter the title of the media to remove: ");
                    String titleToRemove = scanner.nextLine();
                    Media mediaToRemove = cart.findMedia(titleToRemove);
                    
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("No media found with title: " + titleToRemove);
                    }
                    break;

                case 4:
                    System.out.print("Enter the title of the media to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = cart.findMedia(titleToPlay);
                    
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            ((Playable) mediaToPlay).play();
                        } else {
                            System.out.println("The media '" + titleToPlay + "' is not playable (it's a Book!).");
                        }
                    } else {
                        System.out.println("No media found with title: " + titleToPlay);
                    }
                    break;
                case 5:
                    System.out.println("Order has been created. Cart is empty.");
                    cart.clear();
                    break;
            }
        }
    }


    public static void initStore() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book(1, "Java Programming", "Education", 25.0f));
    }

    private static Media findMediaInStore(String title) {
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public static void updateStore() {
        System.out.println("1. Add Media / 2. Remove Media");
        int choice = scanner.nextInt(); scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter title: ");
            store.addMedia(new DigitalVideoDisc(scanner.nextLine()));
        } else {
            System.out.print("Enter title to remove: ");
            Media m = findMediaInStore(scanner.nextLine());
            if (m != null) store.removeMedia(m);
        }
    }
}