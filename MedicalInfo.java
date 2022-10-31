import java.util.ArrayList;

public class MedicalInfo {
    private ArrayList<String> allergies;
    private ArrayList<Contact> emergencyContact;
    private String address;
    private ArrayList<String> medNotes;
    private Pediatrician pediatrician;

  
    //TODO add waiver functionality??

    public Pediatrician getPediatrician() {
        return pediatrician;
    }

    /**
     * Initializes the medical information for the user
     *
     * @param emergencyContact  who would the camp call if there's an emergency
     * @param address   where the child lives
     */
    public MedicalInfo(ArrayList<Contact> emergencyContact, String address, ArrayList<String> allergies, ArrayList<String> medNotes, Pediatrician pediatrician) {
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.address = address;
        this.medNotes = medNotes;
        this.pediatrician = pediatrician;

    }

    /******************
     * Lets just change conditions to medNotes
     ******************/
//    public ArrayList<String> getMedAndAdmin() {
//        return this.ChildMedicationAndAdministration;
//    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public ArrayList<Contact> getEmergencyContact() {
        return emergencyContact;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getMedNotes() {
        return medNotes;
    }

    /**
     * Returns a description of the user's medical information
     * 
     * @return String   a summarized version of medical info
     */
    public String toString() {
        String ret = "Medical Info:";
        ret += "\tAllergies: ";
        for(String s : allergies){
            ret += s + ", ";
        }
        ret += "\n\t" + emergencyContact.toString();
        // "Allergies: " + this.allergies + "Emergency Contact: "+this.emergencyContact+" Address: "+this.address+" Conditions: "+this.medNotes+" Pediatrician: "+this.pediatrician;
        return ret;
    }
    
}
