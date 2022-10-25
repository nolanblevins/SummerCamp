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

    public void addGroup(){

    }

    public Group getGroup(UUID uuid){
        for(Group g : groups){
            if(g.getUUID().compareTo(uuid) == 0){
                return g;
            }
        }
        return null;
    }

    public void editGroup(Group group){

    }

    public void saveGroups(){

    }
}

