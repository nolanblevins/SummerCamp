import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Counselor extends User {
    protected Date birthday;
    protected MedicalInfo medicalInfo;
    protected Group group;

    /**
     * Parameterized constructor that also generates random UUID
     * 
     * @param firstName   Counselor first name
     * @param lastName    Counselor last name
     * @param email       Counselor email
     * @param phoneNumber Counselor phoneNumber
     * @param password    Counselor password
     * @param birthday    Counselor bday
     */
    public Counselor(String firstName, String lastName, String email, String phoneNumber, String password,
            Date birthday, MedicalInfo medicalInfo) {
        super(firstName, lastName, email, phoneNumber, password);
        this.birthday = birthday;
        this.medicalInfo = medicalInfo;
        this.userType = UserType.COUNSELOR;
    }

    /**
     * Parameterized constructor that also generates sets ID
     * 
     * @param id          randomly generated UUID
     * @param firstName   Counselor first name
     * @param lastName    Counselor last name
     * @param email       Counselor email
     * @param phoneNumber Counselor phoneNumber
     * @param password    Counselor password
     * @param birthday    Counselor bday
     */
    public Counselor(UUID id, String firstName, String lastName, String email, String phoneNumber, String password,
            Date birthday, MedicalInfo medicalInfo) {
        super(id, firstName, lastName, email, phoneNumber, password);
        this.birthday = birthday;
        this.medicalInfo = medicalInfo;
        this.userType = UserType.COUNSELOR;
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
    public Schedule viewSchedule(WeekDay weekDay) {
        Schedule dailySchedule = new Schedule(null, null);
        dailySchedule = dailySchedule.getDailySchedule(weekDay);
        return dailySchedule;
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
    public ArrayList<Child> getChildren(Group group) {
        return group.getCampers();
    }

    /**
     * method to get counselor med info
     * 
     * @return will return counselors med info
     */
    public MedicalInfo getMedInfo() {
        return medicalInfo;
    }

    /**
     * method to get child med info
     * 
     * @return will return child med info
     */
    public MedicalInfo getChildMedInfo(Child child) {
        return child.getMedInfo();

    }

    public void setMedicalInfo(MedicalInfo medicalInfo){
        this.medicalInfo = medicalInfo;
    }

    public Date getBirthday() {
        return birthday;
    }
}
