import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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
     * @param notes     childs notes
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
    public Child(UUID id, String firstName, String lastName, MedicalInfo medicalInfo, Date birthday, ArrayList<String> notes) {
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
     * Accesses Child UUID
     * 
     * @return will return the child UUID
     */
    public UUID getUUID(){
        return this.id;
    }

    /**
     * A concatenated toString of Child values
     * 
     * @return will return a concatenated
     */
    public String toString() {
        return "Child [firstName=" + firstName + ", lastName=" + lastName + ", medicalInfo=" + medicalInfo
                + ", birthday=" + birthday + "]";
    }

}
