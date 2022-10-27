import java.util.ArrayList;

public class MedicalInfo {
    private ArrayList<String> allergies;
    private ArrayList<Contact> emergencyContact;
    private String address;
    private ArrayList<String> conditions;

  
    //TODO add waiver functionality??
    /**
     * Initializes the medical information for the user
     *
     * @param emergencyContact  who would the camp call if there's an emergency
     * @param address   where the child lives
     */
    public MedicalInfo(ArrayList<Contact> emergencyContact, String address, ArrayList<String> allergies, ArrayList<String> conditions) {
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.address = address;
        this.conditions = conditions;

    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public ArrayList<Contact> getEmergencyContact() {
        return emergencyContact;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    /**
     * Returns a description of the user's medical information
     * 
     * @return String   a summarized version of medical info
     */
    public String toString() {
        return "Allergies: "+this.allergies + "Emergency Contact: "+this.emergencyContact+" Address: "+this.address;
    }
    
}
