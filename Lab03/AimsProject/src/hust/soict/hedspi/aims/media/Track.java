package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { 
    	return title; 
    }
    
    public int getLength() { 
    	return length; 
    }
    
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("Track " + this.getTitle() + " cannot be played because its length is 0 or less!");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) {
            return false;
        }
        Track other = (Track) o;
        return this.title.equalsIgnoreCase(other.getTitle()) 
               && this.length == other.getLength();
    }
}