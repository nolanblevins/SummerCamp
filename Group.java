import java.sql.Array;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

public class Group {
    private String groupName;
    private ArrayList<Schedule> schedule;
    private int cabin;
    private ArrayList<Child> campers;
    private int groupSize;
    private Counselor counselor;
    private UUID id;
    private Date max;
    private Date min;

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

    public Group(UUID id, String groupName, int cabin, int groupSize, User counselor,
            ArrayList<Child> campers, ArrayList<Schedule> schedule, Date min, Date max) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.id = id;
        this.campers = campers;
        this.counselor = (Counselor) counselor;
        this.schedule = schedule;
        this.max = max;
        this.min = min;
    }

    public void createSchedule() {
        Schedule s = new Schedule(null, null);
        this.schedule = s.generateSchedule();
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public Counselor getCounselor() {
        return this.counselor;
    }

    public ArrayList<Child> getCampers() {
        return this.campers;
    }

    public Group getGroupByCounselor(Counselor counselor) {
        Camp c = new Camp(null, 0, null, null);
        ArrayList<Group> groups = new ArrayList<Group>();
        groups = c.getGroups();
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getCounselor() == counselor) {
                return groups.get(i);
            }
        }
        return null;
    }

    public Group getGroupByChild(Child child) {
        for (Child c : campers) {
            if (c.getUUID().compareTo(child.getUUID()) == 0) {
                return this;
            }
        }
        return null;
    }

    public UUID getUUID() {
        return this.id;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getCabin() {
        return cabin;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public Date getMax(){
        return this.max;
    }

    public Date getMin(){
        return this.min;
    }

    public void addChild(Child child){
        campers.add(child);
        groupSize++;
    }

    public boolean childFits(Child child){
        Date bday = child.getBirthday();
        if(groupSize <= 8 && max.after(bday) && min.before(bday)){
            return true;
        }
        return false;
    }

    public void removeChild(Child child){
        for(Child c : campers){
            if(c.getUUID().compareTo(child.getUUID()) == 0){
                campers.remove(c);
                groupSize--;
                break;
            }
        }
    }

    public String toString() {
        return "Group [groupName=" + groupName + ", schedule=" + schedule + ", cabin=" + cabin + ", campers=" + campers
                + ", groupSize=" + groupSize + ", counselor=" + counselor + ", id=" + id + "]";
    }

}
