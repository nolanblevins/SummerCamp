import java.util.UUID;

public class Activity {
    private UUID uuid;
    private String title;
    private int duration; // in hours
    private String description;
    private String location;

    /**
     * This method is a constructor for Activity
     * 
     * @param title       Name of activity
     * @param duration    Length of time in hours of activity
     * @param description description of what activity is
     * @param location    where the activity takes place
     */
    public Activity(String title, int duration, String description, String location) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.location = location;
    }

    /**
     * The method is a constructor for Activity including the UUID
     * 
     * @param uuid        generated uuid for activity
     * @param title       Name of activity
     * @param duration    Length of time in hours of activity
     * @param description description of what activity is
     * @param location    where the activity takes place
     */
    public Activity(UUID uuid, String title, int duration, String description, String location) {
        this.uuid = uuid;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.location = location;
    }

    /**
     * Accessor for UUID
     * 
     * @return UUID for activity
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Accessor for title
     * 
     * @return title for activity
     */
    public String getTitle() {
        return title;
    }

    /**
     * Accessor for duration
     * 
     * @return duration for activity
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Accessor for description
     * 
     * @return description for activity
     */
    public String getDescription() {
        return description;
    }

    /**
     * Accessor for location
     * 
     * @return location for activity
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method returns all of the parameters for activity in the form of a string
     * 
     * @return a concatenate string of the activity properties
     */
    public String toString() {
        return "Activity [title= " + title + ", time= " + duration + "minutes, description= " + description
                + ", location= " + location
                + "]";
    }

}