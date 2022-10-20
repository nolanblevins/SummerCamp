public class Activity {
    private String title;
    private int duration;
    private String description;
    private String location;
    
    public Activity(String title, int duration, String description, String location) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.location = location;
    }

    public String toString() {
        return "Activity [title=" + title + ", time=" + duration + ", description=" + description + ", location=" + location
                + "]";
    }
    
    
}
