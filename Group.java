import java.sql.Array;
import java.time.LocalDate;
import java.time.Period;
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
    private int max;
    private int min;

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
            ArrayList<Child> campers, ArrayList<Schedule> schedule, int min, int max) {
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
        Camp c = new Camp(null, 0, null);
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

    public int getMax(){
        return this.max;
    }

    public int getMin(){
        return this.min;
    }

    public void addChild(Child child){
        campers.add(child);
        groupSize++;
    }
    

    public boolean childFits(Child child){
        int childAge = calculateAge(child);
        if(groupSize <= 8 && !campers.contains(child) && max >= (childAge) && min <= (childAge)){
            return true;
        }
        return false;
    }

    public int calculateAge(Child child) {
        LocalDate curDate = LocalDate.now();
        String childBday = child.getBirthday().toString();
        LocalDate dob = LocalDate.parse(childBday);
        return Period.between(dob, curDate).getYears();
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
