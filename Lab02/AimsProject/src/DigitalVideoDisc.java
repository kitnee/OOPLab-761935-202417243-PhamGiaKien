public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.category = "";
        this.director = "";
        this.length = 0;
        this.cost = 0.0f;

        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.director = "";
        this.length = 0;
        this.cost = cost;

        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = 0;
        this.cost = cost;

        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
    }   

    public void setTitle(String title) {
        this.title = title;
    }

    private static int nbDigitalVideoDiscs = 0;
    
    private int id;

    public int getId() {
        return id;
    }
}