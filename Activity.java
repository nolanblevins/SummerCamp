public class Activity {
    private String title;
    private String time;
    private String description;
    private String location;
    
    public Activity(String title, String time, String description, String location) {
        this.title = title;
        this.time = time;
        this.description = description;
        this.location = location;
    }

    public String toString() {
        return "Activity [title=" + title + ", time=" + time + ", description=" + description + ", location=" + location
                + "]";
    }
    
    
}
