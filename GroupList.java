import java.util.ArrayList;
public class GroupList {
    private ArrayList<Group> groups;
    private static GroupList groupList;

    private GroupList(){
        this.groups = DataReader.getAllGroups();
    }

    public static GroupList getInstance(){
        if(groupList == null){
            groupList = new GroupList();
        }
        return groupList;
    }

    public void addGroup(){

    }

    public Group getGroup(){
        return null;
    }

    public void editGroup(Group group){

    }

    public void saveGroups(){

    }
}

