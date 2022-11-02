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
    
    /**
     * Accessor for Allergies
     * 
     * @return users allergies
     */
    public ArrayList<String> getAllergies() {
        return allergies;
    }

    /**
     * Accessor for Emergency Contact
     * 
     * @return users emergencyContact
     */
    public ArrayList<Contact> getEmergencyContact() {
        return emergencyContact;
    }
    
    /**
     * Accessor for Address
     * 
     * @return users Address
     */
    public String getAddress() {
        return address;
    }


    /**
     * Accessor for Medical Notes
     * 
     * @return users medical Notes
     */
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
        ret += "\n\tAllergies: ";
        for(String s : allergies){
            ret += s + ", ";
        }

        for(Contact c : emergencyContact){
            ret += "\n\t" + c.toString();
        }

        ret += "\n\tAddress: " + this.address;
        ret += "\n\tConditions: ";
        for(String s : medNotes){
            ret += s + ", ";
        }
        ret += "\n\t" + pediatrician.toString();
        // "Allergies: " + this.allergies + "Emergency Contact: "+this.emergencyContact+" Address: "+this.address+" Conditions: "+this.medNotes+" Pediatrician: "+this.pediatrician;
        return ret;
    }
    
}
