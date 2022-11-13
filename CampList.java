import java.util.ArrayList;
import java.util.UUID;
public class CampList {
    private ArrayList<Camp> camps;
    private static CampList campList;

    /**
     * Camplist constructor
     */
    private CampList(){
        camps = DataReader.loadCamps();
    }

    /**
     * Gets an instance of CampList - constructs it first if it is null
     *
     * @return  Instance of campList
     */
    public static CampList getInstance(){
        if(campList == null){
            campList = new CampList();
        }
        return campList;
    }

    /**
     * Adds a camp to campList
     *
     * @param camp  The camp to be added
     */
    public void addCamp(Camp camp){
        this.camps.add(camp);
    }

    public Camp getCamp(String theme){
        return null;
    }

    public Camp getCamp(UUID uuid){
        for(Camp c: camps){
            if(c.getUuid().compareTo(uuid) == 0){
                return c;
            }
        }
        return null;
    }
    public ArrayList<Camp> getCamp(Child child){
        ArrayList<Camp> ret = new ArrayList<>();
        for(Camp c : camps){
            ArrayList<Group> groups = c.getGroups();
            for(Group g : groups){
                if(g.getGroupByChild(child) != null){
                    ret.add(c);
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * Gets all the camps that a counselor works at
     *
     * @param counselor     The counselor that is being checked for
     * @return              The camps the counselor works at
     */
    public ArrayList<Camp> getCamp(Counselor counselor){
        ArrayList<Camp> ret = new ArrayList<>();
        for(Camp c : camps){
            ArrayList<Group> groups = c.getGroups();
            for(Group g : groups){
                if(g.getGroupByCounselor(counselor) != null){
                    ret.add(c);
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * Returns a list of every camp
     *
     * @return  ArrayList of camps
     */
    public ArrayList<Camp> getAllCamps(){
        return this.camps;
    }

    /**
     * Method to edit camps
     *
     * @param camp  The camp that is being changed
     */
    public void editCamp(Camp camp){
        for(Camp c : camps){
            if(camp.getUuid().compareTo(c.getUuid()) == 0){
                c = camp;
                return;
            }
        }
    }

    public void saveCamps(){
        DataWriter.saveCamps();
    }

    /**
     * Added for testing
     */
    public void clear(){
        camps.clear();
    }

}
