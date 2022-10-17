import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Child {
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected ArrayList<String> notes;
    protected MedicalInfo medicalInfo;
    protected Date birthday;
    
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
    
}
