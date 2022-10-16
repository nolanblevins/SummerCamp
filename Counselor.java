import java.util.Date;

public class Counselor extends User {
    protected Date birthday;
    protected MedicalInfo medicalInfo;
    protected Group group;
    
    public Counselor(String firstName, String lastName, String email, String phoneNumber, String password,
            Date birthday) {
        super(firstName, lastName, email, phoneNumber, password);
        this.birthday = birthday;
    }

    
    
}
