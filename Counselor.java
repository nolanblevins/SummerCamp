import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Counselor extends User {
    protected UUID id;
    protected Date birthday;
    protected MedicalInfo medicalInfo;
    protected Group group;

    /**
     * Parameterized constructor that also generates random UUID
     * 
     * @param firstName Counselor first name
     * @param lastName Counselor last name
     * @param email Counselor email
     * @param phoneNumber Counselor phoneNumber
     * @param password Counselor password
     * @param birthday Counselor bday
     */
    public Counselor(String firstName, String lastName, String email, String phoneNumber, String password,
            Date birthday) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = UUID.randomUUID();
        this.birthday = birthday;
    }

    /**
     * Parameterized constructor that also generates sets ID
     * 
     * @param id randomly generated UUID
     * @param firstName Counselor first name
     * @param lastName Counselor last name
     * @param email Counselor email
     * @param phoneNumber Counselor phoneNumber
     * @param password Counselor password
     * @param birthday Counselor bday
     */
    public Counselor(UUID id, String firstName, String lastName, String email, String phoneNumber, String password,
            Date birthday) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = id;
        this.birthday = birthday;
    }

    /**
     * Adds a customized note to child of choice
     * 
     * @param child the child in which the note will be added
     * @param note  the note being added to the child
     */
    public void addNotes(Child child, String note) {
        child.addNote(note);
    }

    /**
     * Allows the counselor to see the schedule
     * 
     * @return will return the full daily schedule
     */
    public String viewSchedule() {
        return "schedule";
    }

    /**
     * Will return the size of the group that the counselor is apart of
     * 
     * @return size of group
     */
    public int getGroupSize() {
        int groupSize = 8;
        return groupSize;
    }

    /**
     * Allows counselor to see children
     * 
     * @return will return the ArrayList of children in the counselors group
     */
    public ArrayList<Child> getChildren() {
        ArrayList<Child> children;
        return null;
    }

    /**
     * method to get counselor med info
     * 
     * @return will return counselors med info
     */
    public String getMedInfo() {
        return "med info";
    }

    /**
     * method to get child med info
     * 
     * @return will return child med info
     */
    public String getChildMedInfo(Child child) {
        return "child med info";
    }

}
