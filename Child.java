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
    
    public Child(String firstName, String lastName, MedicalInfo medicalInfo, Date birthday) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalInfo = medicalInfo;
        this.birthday = birthday;
    }

    public Child(UUID id, String firstName, String lastName, MedicalInfo medicalInfo, Date birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalInfo = medicalInfo;
        this.birthday = birthday;
    }

    public void addNote(String note) {
        notes.add(note);
    }

    public String getMedInfo() {
        return "med Info";
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
