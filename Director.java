import java.util.UUID;

public class Director extends User {

    private UUID id;

    public Director(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = UUID.randomUUID();
    }

    public Director(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = id;
    }

    /**
     * Creates a new activity and returns it
     * 
     * @param title       The name of the activity
     * @param time        The time of the activity
     * @param description A description of the activity
     * @param location    The location of the activity
     * @return Activty    The overall activity class is returned
     */
    public Activity addActivity(String title, String time, String description, String location) {
        Activity activity = new Activity(title, time, description, location);
        return activity;
    }

    public void addQtoFAQ(String question) {
        // CampSystemFacade.faq.add();
    }

}
