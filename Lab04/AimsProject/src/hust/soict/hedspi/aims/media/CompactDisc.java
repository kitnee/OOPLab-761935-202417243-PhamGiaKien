package hust.soict.hedspi.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() { 
        return artist; 
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' has been added to CD: " + this.getTitle());
        } else {
            System.out.println("Track '" + track.getTitle() + "' is already in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track '" + track.getTitle() + "' has been removed from CD: " + this.getTitle());
        } else {
            System.out.println("Track '" + track.getTitle() + "' does not exist in this CD.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
            System.out.println("CD total length: " + this.getLength());
            for (Track track : tracks) {
                track.play(); 
            }
        } else {
            System.out.println("CD " + this.getTitle() + " cannot be played because it has no tracks or total length is 0"); 
        }
    }
}