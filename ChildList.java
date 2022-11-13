import java.util.ArrayList;
import java.util.UUID;

public class ChildList{
    private ArrayList<Child> children;
    private static ChildList childList;

    /**
     * Child List constructor that calls the load child method
     * in data reader
     */
    private ChildList(){
        this.children = DataReader.loadChild();
    }

    /**
     * Returns an instance of ChildList, constructs it first if it is null
     *
     * @return  Instance of ChildList
     */
    public static ChildList getInstance(){
        if(childList == null){
            childList = new ChildList();
        }
        return childList;
    }

    /**
     * Adds a child to the list
     *
     * @param child     The child to be added
     */
    public void addChild(Child child){
        this.children.add(child);
    }

    /**
     * Gets a child by the childs name
     *
     * @param name  The childs name
     * @return      The child with the correct name
     */
    public Child getChild(String name){
        String[] names = name.split(" ");
        for(Child c : children){
            if(names[0].equalsIgnoreCase(c.getFirstName()) && names[1].equalsIgnoreCase(c.getLastName())){
                return c;
            }
        }

        return null;
    }

    /**
     * Gets a child by UUID
     *
     * @param uuid  The UUID of the child
     * @return      The child with the correct UUID
     */
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

    /**
     * Returns a list of all children
     *
     * @return  ArrayList of children
     */
    public ArrayList<Child> getChildren(){
        return this.children;
    }

    /**
     * Allows it to edit the child
     *
     * @param child     The child to be edited
     */
    public void editChild(Child child){
        for(Child c : children){
            if(child.getUUID().compareTo(c.getUUID()) == 0){
                c = child;
                return;
            }
        }
    }

    /**
     * Removes a child from the list
     *
     * @param child     The child to be removed
     */
    public void removeChild(Child child){
        for(Child c : children){
            if(c.getUUID().compareTo(child.getUUID()) == 0){
                children.remove(c);
                break;
            }
        }
    }

    /**
     * Saves the children to a JSON file
     */
    public void saveChildren(){
        DataWriter.saveChildren();
    }

    /**
     * Added for testing
     */
    public void clear(){
        children.clear();
    }
}
