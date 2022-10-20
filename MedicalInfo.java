import java.util.ArrayList;

public class MedicalInfo {
    private ArrayList<String> allergies;
    private String guardian;
    private Contact emergencyContact;
    private String address;
    private ArrayList<String> conditions;

    //TODO Changed emergencyContact to contact :)
    //TODO add allergies to constructor :)
    //TODO add some kind of "other" medical info
    //TODO add waiver functionality??
    /**
     * Initializes the medical information for the user
     * 
     * @param guardian  who is in charge of the child
     * @param emergencyContact  who would the camp call if there's an emergency
     * @param address   where the child lives
     */
    public MedicalInfo(String guardian, Contact emergencyContact, String address, ArrayList<String> allergies, ArrayList<String> conditions) {
        this.allergies = allergies;
        this.guardian = guardian;
        this.emergencyContact = emergencyContact;
        this.address = address;
        this.conditions = conditions;

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
