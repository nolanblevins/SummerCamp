import java.util.ArrayList;
public class CampList {
    private ArrayList<Camp> camps;
    private static CampList campList;

    private CampList(){
        camps = DataReader.loadCamps();
    }

    public static CampList getInstance(){
        if(campList == null){
            campList = new CampList();
        }
        return campList;
    }

    public void addCamp(Camp camp){
        this.camps.add(camp);
    }

    public Camp getCamp(String theme){
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

    public ArrayList<Camp> getAllCamps(){
        return this.camps;
    }

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

}
