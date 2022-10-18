import java.util.ArrayList;
import java.util.UUID;

public class Group {
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
    }

    public Group(UUID id, String groupName, int cabin, int groupSize) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.id = id;
    }

    public Schedule getSchedule() {
        return null;
    }

    public String toString() {
        return "Group [groupName=" + groupName + ", schedule=" + schedule + ", cabin=" + cabin + ", campers=" + campers
                + ", groupSize=" + groupSize + ", counselor=" + counselor + ", id=" + id + "]";
    }

   
    
}
