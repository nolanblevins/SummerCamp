import java.util.UUID;

public class Director extends User {
    /*
     * need a create camp method
     */

    public Director(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.userType = UserType.DIRECTOR;
    }

    public Director(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(id, firstName, lastName, email, phoneNumber, password);
        this.userType = UserType.DIRECTOR;
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
    public Activity addActivity(String title, int time, String description, String location) {
        Activity activity = new Activity(title, time, description, location);
        return activity;
    }

    public void addtoFAQ(String question, String answer) {
        new FAQ(question, answer);
    }

}
