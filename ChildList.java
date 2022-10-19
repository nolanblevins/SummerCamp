import java.util.ArrayList;
import java.util.UUID;

public class ChildList{
    private ArrayList<Child> children;
    private static ChildList childList;

    private ChildList(){
        this.children = DataReader.loadChild();
    }

    public static ChildList getInstance(){
        if(childList == null){
            childList = new ChildList();
        }
        return childList;
    }

    public void addChild(){

    }

    public Child getChild(String name){
        return null;
    }

    public Child getChild(UUID uuid){
        return null;
    }

    public void editUser(Child child){

    }

    public void saveUsers(){

    }
}
