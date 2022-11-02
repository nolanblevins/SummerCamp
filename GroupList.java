import java.util.ArrayList;
import java.util.UUID;

public class GroupList {
    private ArrayList<Group> groups;
    private static GroupList groupList;

    private GroupList(){
        this.groups = DataReader.loadGroups();
    }

    /**
    * Method to get an Instance of GroupList
    *
    * @return an Instance of groupList
    */
    public static GroupList getInstance(){
        if(groupList == null){
            groupList = new GroupList();
        }
        return groupList;
    }

    /**
     * Method to add a new Group 
     *
     * @param group 
     */
    public void addGroup(Group group){
        this.groups.add(group);
    }

    /**
     * Method to getGroup from UUID
     *
     * @param uuid      Group UUID
     * @return          group if the UUID matches, otherwise null
     */
    public Group getGroup(UUID uuid){
        for(Group g : groups){
            if(g.getUUID().compareTo(uuid) == 0){
                return g;
            }
        }
        return null;
    }

    /**
     * Method to get All Group in the Camp
     *
     * @return ArrayList of groups.
     */
    public ArrayList<Group> getAllGroups(){
        return groups;
    }

    /**
     * Method to edit Group
     * 
     * @param group:
     * 
     */
    public void editGroup(Group group){
        for(Group g : groups){
            if(group.getUUID().compareTo(g.getUUID()) == 0){
                g = group;
                return;
            }
        }
    }

    /**
     * Method to save Group from DataWriter
     */
    public void saveGroups(){
        DataWriter.saveGroups();
    }
}

