import java.util.UUID;
/**
 * Class to manage and create activities for the camp
 */
public class Activity {
    private UUID uuid;
    private String title;
    private int duration; // in hours
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

    /**
     * Method to get activity ID
     * 
     * @return UUID of activity
     */
    public UUID getUuid() {
        return uuid;
    }
    /**
     * Method to get activity title
     * 
     * @return title of activity
     */
    public String getTitle() {
        return title;
    }
    /**
     * Method to get activity duration
     * 
     * @return duration of activity
     */
    public int getDuration() {
        return duration;
    }
    /**
     * Method to get activity description
     * 
     * @return description of activity
     */
    public String getDescription() {
        return description;
    }
    /**
     * Method to get activity location
     * 
     * @return location of activity
     */
    public String getLocation() {
        return location;
    }
    /**
     * Method to return concatenated toString
     * 
     * @return string of concatenated activity values
     */
    public String toString() {
        return "Activity [title= " + title + ", time= " + duration + "minutes, description= " + description + ", location= " + location
                + "]";
    }
    
    
}
