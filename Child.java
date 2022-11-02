import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

/*
 * This class is the manager of a Child
 */
public class Child {
    private UUID id;
    private String firstName;
    private String lastName;
    private ArrayList<String> notes;
    private MedicalInfo medicalInfo;
    private Date birthday;

    /**
     * Parameterized constructor that generates Random UUID
     * 
     * @param firstName   childs first name
     * @param lastName    childs last name
     * @param medicalInfo childs med info
     * @param birthday    child bday
     */
    public Child(String firstName, String lastName, MedicalInfo medicalInfo, Date birthday) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalInfo = medicalInfo;
        this.birthday = birthday;
        notes = new ArrayList<>();
    }

    /**
     * Parameterized constructor that sets ID
     * 
     * @param id          childs random id
     * @param firstName   childs first name
     * @param lastName    childs last name
     * @param medicalInfo childs med info
     * @param birthday    child bday
     * @param notes
     */
    public Child(UUID id, String firstName, String lastName, MedicalInfo medicalInfo, Date birthday,
            ArrayList<String> notes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalInfo = medicalInfo;
        this.birthday = birthday;
        this.notes = notes;
    }

    /**
     * Adds note to child
     * 
     * @param note note to be added
     */
    public void addNote(String note) {
        notes.add(note);
    }

    /**
     * Accesses Child med info
     * 
     * @return will return child med info
     */
    public MedicalInfo getMedInfo() {
        return medicalInfo;
    }

    /**
     * Accesses Child first name
     * 
     * @return will return child first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accesses Child last night
     * 
     * @return will return child last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Accesses Child notes
     * 
     * @return will return child notes
     */
    public ArrayList<String> getNotes() {
        return notes;
    }

    /**
     * Accesses Child birthday
     * 
     * @return will return child birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Accesses Child UUID
     * 
     * @return will return the child UUID
     */
    public UUID getUUID() {
        return this.id;
    }

    /**
     * This method makes sure nothing is null and assigns it to the correct variable
     * 
     * @param firstName   is first name of child
     * @param lastName    is last name of child
     * @param medicalInfo is medical info of child
     */
    public void changeInfo(String firstName, String lastName, MedicalInfo medicalInfo) {
        if (firstName != null) {
            this.firstName = firstName;
        }
        if (lastName != null) {
            this.lastName = lastName;
        }
        if (medicalInfo != null) {
            this.medicalInfo = medicalInfo;
        }
    }

    /**
     * A concatenated toString of Child values
     * 
     * @return will return a concatenated
     */
    public String toString() {
        String pattern = "MM/dd/yyyy";
        return "Name: " + firstName + " " + lastName +
                "\nBirthday: " + new SimpleDateFormat(pattern).format(birthday);
    }

}
