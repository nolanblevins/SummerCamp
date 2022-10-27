import java.sql.Array;
import java.util.ArrayList;
import java.util.UUID;

public class Group {

    /*********************
     * DO WE NEED AN AGE RANGE
     *********************/

    private String groupName;
    private Schedule schedule;
    private int cabin;
    private ArrayList<Child> campers;
    private int groupSize;
    private Counselor counselor;
    private UUID id;
    
    public Group(String groupName, int cabin, int groupSize) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.id = UUID.randomUUID();
        this.campers = new ArrayList<>();
    }

    public Group(UUID id, String groupName, int cabin, int groupSize) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.id = id;
        this.campers = new ArrayList<>();
    }

    public Group(UUID id, String groupName, int cabin, int groupSize, User counselor, ArrayList<Child> campers) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.id = id;
        this.campers = campers;
        this.counselor = (Counselor) counselor;
    }

    public ArrayList<Schedule> getSchedule() {
        ArrayList<Schedule> schedule = new ArrayList<>();
        Schedule sc = new Schedule(null, null);
        schedule = sc.generateSchedule();
        return schedule;
    }
    public Counselor getCounselor() {
        return this.counselor;
    }
    public Group getGroupByCounselor(Counselor counselor) {
        Camp c = new Camp(null, 0, null);
        ArrayList<Group> groups = new ArrayList<Group>();
        groups = c.getGroups();
        for(int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getCounselor()==counselor) {
                return groups.get(i);
            }
        }
    }

    public UUID getUUID(){
        return this.id;
    }

    public String toString() {
        return "Group [groupName=" + groupName + ", schedule=" + schedule + ", cabin=" + cabin + ", campers=" + campers
                + ", groupSize=" + groupSize + ", counselor=" + counselor + ", id=" + id + "]";
    }

   
    
}
