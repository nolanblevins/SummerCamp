import java.util.ArrayList;
import java.util.UUID;

public class GroupList {
    private ArrayList<Group> groups;
    private static GroupList groupList;

    private GroupList(){
        this.groups = DataReader.loadGroups();
    }

    /**
    * Return an Instance of list of Group
    *
    * @return groupList - List of Group
    */
    public static GroupList getInstance(){
        if(groupList == null){
            groupList = new GroupList();
        }
        return groupList;
    }

    /**
     * Method to add Group to the list of Group
     *
     * @param group group needed to be add
     */
    public void addGroup(Group group){
        this.groups.add(group);
    }

    /**
     * Return the Group associated with UUID
     *
     * @param uuid      Group UUID
     * @return  g       group matches with the UUID, otherwise null
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
     * @return group        List of Group
     */
    public ArrayList<Group> getAllGroups(){
        return groups;
    }

    /**
     * Method to edit Group
     * 
     * @param group:    group needed to be edited
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
     * Call DataWriter to save Group
     */
    public void saveGroups(){
        DataWriter.saveGroups();
    }

    /**
     * Added for testing
     */
    public void clear(){
        groups.clear();
    }
}

