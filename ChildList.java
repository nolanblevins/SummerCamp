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

    public void addChild(Child child){
        this.children.add(child);
    }
    

    public Child getChild(String name){
        String[] names = name.split(" ");
        for(Child c : children){
            if(names[0].equalsIgnoreCase(c.getFirstName()) && names[1].equalsIgnoreCase(c.getLastName())){
                return c;
            }
        }

        return null;
    }

    public Child getChild(UUID uuid){
        Child ret = null;
        for(Child c : children){
            if(c.getUUID().compareTo(uuid) == 0){
                ret = c;
                break;
            }
        }
        return ret;
    }

    public ArrayList<Child> getChildren(){
        return this.children;
    }

    public void editUser(Child child){
        for(Child c : children){
            if(child.getUUID().compareTo(c.getUUID()) == 0){
                c = child;
                return;
            }
        }
    }

    public void removeChild(Child child){
        for(Child c : children){
            if(c.getUUID().compareTo(child.getUUID()) == 0){
                children.remove(c);
                break;
            }
        }
    }

    public void saveChildren(){
        DataWriter.saveChildren();
    }
}
