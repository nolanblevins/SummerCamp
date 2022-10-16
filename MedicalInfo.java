import java.util.ArrayList;

public class MedicalInfo {
    private ArrayList<String> allergies;
    private String guardian;
    private String emergencyContact;
    private String address;
    
    public MedicalInfo(String guardian, String emergencyContact, String address) {
        this.guardian = guardian;
        this.emergencyContact = emergencyContact;
        this.address = address;
    }
    
}
