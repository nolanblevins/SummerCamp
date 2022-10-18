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

    }

    //TODO determine how to access camps
    public Camp getCamp(String theme){
        return null;
    }

    public ArrayList<Camp> getAllCamps(){
        return this.camps;
    }

    public void editCamp(Camp camp){

    }

    public void saveCamps(){

    }

}
