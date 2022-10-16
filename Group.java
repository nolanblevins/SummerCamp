import java.util.ArrayList;

public class Group {
    private String groupName;
    private Schedule schedule;
    private int cabin;
    private ArrayList<Child> campers;
    private int groupSize;
    private Counselor counselor;
    
    public Group(String groupName, int cabin, int groupSize) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
    }
    
}
