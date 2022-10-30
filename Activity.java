import java.util.UUID;
public class Activity {
    private UUID uuid;
    private String title;
    private int duration;
    private String description;
    private String location;
    
    /**
     * @param title Name of activity
     * @param duration Length of time in hours of activity
     * @param description description of what activity is
     * @param location where the activity takes place
     */
    public Activity(String title, int duration, String description, String location) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.location = location;
    }

    /**
     * @param uuid generated uuid for activity
     * @param title Name of activity
     * @param duration Length of time in hours of activity
     * @param description description of what activity is
     * @param location where the activity takes place
     */
    public Activity(UUID uuid, String title, int duration, String description, String location) {
        this.uuid = uuid;
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
