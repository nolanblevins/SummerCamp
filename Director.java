import java.util.UUID;

public class Director extends User {

    /**
     * Constructor for Director
     * 
     * @param firstName   is first name of the director
     * @param lastName    is last name of the director
     * @param email       is the email of the director
     * @param phoneNumber is the phone number of the director
     * @param password    is the password of the director
     */
    public Director(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.userType = UserType.DIRECTOR;
    }

    /**
     * Constructor for the Director including UUID
     * 
     * @param id          is the UUID of the director
     * @param firstName   is first name of the director
     * @param lastName    is last name of the director
     * @param email       is the email of the director
     * @param phoneNumber is the phone number of the director
     * @param password    is the password of the director
     */
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
     * @return Activty The overall activity class is returned
     */
    public Activity addActivity(String title, int time, String description, String location) {
        Activity activity = new Activity(title, time, description, location);
        return activity;
    }

    /**
     * This method lets the director add a FAQ
     * 
     * @param question is the questions of the faq
     * @param answer   is the answer of the faq
     */
    public void addtoFAQ(String question, String answer) {
        new FAQ(question, answer);
    }

}
