import java.sql.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Formatter;
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

    /**
     * This method is a constructor for Group
     *
     * @param groupName Group Name
     * @param cabin     Cabin numbers
     * @param groupSize Size of the group
     */
    public Group(String groupName, int cabin, int groupSize) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.id = UUID.randomUUID();
        this.campers = new ArrayList<>();
    }

    /**
     * This method is a constructor for Group including UUID
     * 
     * @param id        Group ID
     * @param groupName Group Name
     * @param cabin     Cabin numbers
     * @param groupSize Size of the group
     */
    public Group(UUID id, String groupName, int cabin, int groupSize) {
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.id = id;
        this.campers = new ArrayList<>();
    }

    public Group(String groupName, int cabin, int groupSize,
            Counselor counselor, int min, int max) {
        this.id = UUID.randomUUID();
        this.campers = new ArrayList<>();
        this.groupName = groupName;
        this.cabin = cabin;
        this.groupSize = groupSize;
        this.counselor = counselor;
        this.min = min;
        this.max = max;
    }

    /**
     * This method is a constructor for Group including UUID, conselor, camps, and
     * schedule
     *
     * @param id        Group ID
     * @param groupName Group Name
     * @param cabin     Cabin numbers
     * @param groupSize Size of the group
     * @param counselor Group Counselor
     * @param campers   Campers
     * @param schedule  Schedule for the Group
     * @param min
     * @param max
     */
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

    /**
     * Generate new Schedule
     *
     */
    public void createSchedule() {
        Schedule s = new Schedule(null, null);
        this.schedule = s.generateSchedule();
    }

    /**
     * Accessor for Group Schedule
     * 
     * @return Group Schedule
     */
    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    /**
     * Accessor for Group Counselor
     * 
     * @return Group Counselor
     */
    public Counselor getCounselor() {
        return this.counselor;
    }

    /**
     * Accessor for Campers
     * 
     * @return Camper
     */
    public ArrayList<Child> getCampers() {
        return this.campers;
    }

    /**
     * Get group from userType: Registered
     * 
     * @param child Child
     * @return Group
     *
     */
    public Group getGroupByChild(Child child) {
        for (Child c : campers) {
            if (c.getUUID().compareTo(child.getUUID()) == 0) {
                return this;
            }
        }
        return null;
    }

    /**
     * Get group by Counselor user
     * 
     * @param counselor
     * @return Group
     */
    public Group getGroupByCounselor(Counselor counselor) {
        if (this.counselor.getID().compareTo(counselor.getID()) == 0) {
            return this;
        }
        return null;
    }

    /**
     * Accessor for UUID
     * 
     * @return UUID
     */
    public UUID getUUID() {
        return this.id;
    }

    /**
     * Accessor for Group Name
     * 
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Accessor for Cabin number
     * 
     * @return Cabin number
     */
    public int getCabin() {
        return cabin;
    }

    /**
     * Accessor for Group Size
     * 
     * @return Group Size
     */
    public int getGroupSize() {
        return groupSize;
    }

    /**
     * Accessor for Max
     * 
     * @return max
     */
    public int getMax() {
        return this.max;
    }

    /**
     * Accessor for Min
     * 
     * @return Min
     */
    public int getMin() {
        return this.min;
    }

    /**
     * Method to add Child to the Group
     * 
     * @param child
     */
    public void addChild(Child child) {
        campers.add(child);
        groupSize++;
    }

    /**
     * Method to check if Child fits in the Camps Age Range
     * 
     * @param child Child's Info
     * @return boolean
     */
    public boolean childFits(Child child) {
        int childAge = calculateAge(child);
        if (groupSize <= 8 && !campers.contains(child) && max >= (childAge) && min <= (childAge)) {
            return true;
        }
        return false;
    }

    /**
     * Method to calculate child's Age
     * 
     * @param child Child's Info
     * @return int Child's Age
     */
    public int calculateAge(Child child) {
        LocalDate curDate = LocalDate.now();
        LocalDate dob = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(
                child.getBirthday()));
        return Period.between(dob, curDate).getYears();
    }

    /**
     * Method to remove Child from Camp
     * 
     * @param child
     */
    public void removeChild(Child child) {
        for (Child c : campers) {
            if (c.getUUID().compareTo(child.getUUID()) == 0) {
                campers.remove(c);
                groupSize--;
                break;
            }
        }
    }

    /**
     * Return all Group Info
     * 
     * @return String Summarized of Group's Information
     */
    public String toString() {
        return "Cabin Number: " + this.cabin +
                "\n\tGroup Name: " + this.groupName +
                "\n\tGroup Size: " + this.groupSize;
    }

    public String scheduleToString(){
        Formatter fmt = new Formatter();
        fmt.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                "Time", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        for(int i = 0; i < 14; i++){
            int num = (i+8)%12;
            if(num == 0){
                num = 12;
            }
            fmt.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    num + ":00",
                    schedule.get(0).getSchedule().get(i).getTitle(),
                    schedule.get(1).getSchedule().get(i).getTitle(),
                    schedule.get(2).getSchedule().get(i).getTitle(),
                    schedule.get(3).getSchedule().get(i).getTitle(),
                    schedule.get(4).getSchedule().get(i).getTitle(),
                    schedule.get(5).getSchedule().get(i).getTitle(),
                    schedule.get(6).getSchedule().get(i).getTitle());
            fmt.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    " ",
                    schedule.get(0).getSchedule().get(i).getLocation(),
                    schedule.get(1).getSchedule().get(i).getLocation(),
                    schedule.get(2).getSchedule().get(i).getLocation(),
                    schedule.get(3).getSchedule().get(i).getLocation(),
                    schedule.get(4).getSchedule().get(i).getLocation(),
                    schedule.get(5).getSchedule().get(i).getLocation(),
                    schedule.get(6).getSchedule().get(i).getLocation());

            fmt.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "");

        }

        return fmt.toString();
    }

}
