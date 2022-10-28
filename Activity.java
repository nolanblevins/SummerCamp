import java.util.UUID;
public class Activity {
    private UUID uuid;
    private String title;
    private int duration; // units ?
    private String description;
    private String location;
    
    public Activity(String title, int duration, String description, String location) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.location = location;
    }

    public Activity(UUID uuid, String title, int duration, String description, String location) {
        this.uuid = uuid;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.location = location;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        return "Activity [title= " + title + ", time= " + duration + "minutes, description= " + description + ", location= " + location
                + "]";
    }
    
    
}
