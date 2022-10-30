import java.util.ArrayList;
import java.util.UUID;

public class GroupList {
    private ArrayList<Group> groups;
    private static GroupList groupList;

    private GroupList(){
        this.groups = DataReader.loadGroups();
    }

    public static GroupList getInstance(){
        if(groupList == null){
            groupList = new GroupList();
        }
        return groupList;
    }

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public Group getGroup(UUID uuid){
        for(Group g : groups){
            if(g.getUUID().compareTo(uuid) == 0){
                return g;
            }
        }
        return null;
    }

    public ArrayList<Group> getAllGroups(){
        return groups;
    }

    public void editGroup(Group group){
        for(Group g : groups){
            if(group.getUUID().compareTo(g.getUUID()) == 0){
                g = group;
                return;
            }
        }
    }

    public void saveGroups(){
        DataWriter.saveGroups();
    }
}

