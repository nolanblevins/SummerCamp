import java.util.ArrayList;
import java.util.Date;

public class Child {
    protected String firstName;
    protected String lastName;
    protected ArrayList<String> notes;
    protected MedicalInfo medicalInfo;
    protected Date birthday;
    
    public Child(String firstName, String lastName, MedicalInfo medicalInfo, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalInfo = medicalInfo;
        this.birthday = birthday;
    }

    
    
}
