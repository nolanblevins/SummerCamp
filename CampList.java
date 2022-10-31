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

    //TODO determine how to access camps
    public Camp getCamp(String theme){
        return null;
    }
    public Camp getCamp(Child child){
        for(Camp c : camps){
            ArrayList<Group> groups = c.getGroups();
            for(Group g : groups){
                if(g.getGroupByChild(child) != null){
                    return c;
                }
            }
        }
        return null;
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
