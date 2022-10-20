import java.util.ArrayList;

public class MedicalInfo {
    private ArrayList<String> allergies;
    private String guardian;
    private String emergencyContact;
    private String address;

    //TODO Changed emergencyContact to contact
    //TODO add allergies to constructor
    /**
     * Initializes the medical information for the user
     * 
     * @param guardian  who is in charge of the child
     * @param emergencyContact  who would the camp call if there's an emergency
     * @param address   where thw child lives
     */
    public MedicalInfo(String guardian, String emergencyContact, String address) {
        this.guardian = guardian;
        this.emergencyContact = emergencyContact;
        this.address = address;
    }

    /**
     * Returns a description of the user's medical information
     * 
     * @return String   a summarized version of medical info
     */
    public String toString() {
        return "Allergies: "+this.allergies+" Guardian: "+ this.guardian+" Emergency Contact: "+this.emergencyContact+" Address: "+this.address;
    }
    
}
