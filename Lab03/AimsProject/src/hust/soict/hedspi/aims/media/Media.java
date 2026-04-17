package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { 
    	return id; 
    }
    
    public String getTitle() { 
    	return title;
    }
    
    public String getCategory() { 
    	return category; 
    }
    
    public float getCost() { 
    	return cost; 
    }
    
    public void setTitle(String title) { 
    	this.title = title; 
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Media)) {
            return false;
        }
        Media other = (Media) o;
        try {
            return this.title.equalsIgnoreCase(other.getTitle());
        } catch (NullPointerException e) {
            return false;
        }
    }
    
    public static final Comparator<Media> COMPARATOR_BY_TITLE_COST = 
    	    new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARATOR_BY_COST_TITLE = 
    	    new MediaComparatorByCostTitle();
}