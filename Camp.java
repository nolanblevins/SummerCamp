import java.util.*;
import java.text.SimpleDateFormat;

public class Camp {
    private Date date;
    private double price;
    private String theme;
    private ArrayList<Group> groups;
    private UUID uuid;
    private final String groupNames[] = { "Vipers", "Pythons", "Turtles", "Seadogs", "Dolphins", "Wildcats" };

    /**
     * Constructor for the camp
     * 
     * @param date  Start date of camp
     * @param price cost to attend camp
     * @param theme theme of camp
     */

    public Camp(Date date, double price, String theme) {
        this.uuid = UUID.randomUUID();
        this.date = date;
        this.price = price;
        this.theme = theme;
        this.groups = new ArrayList<>();
        UserList userList = UserList.getInstance();
        ArrayList<User> counselors = userList.getUsersByType(UserType.COUNSELOR);
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int random = rand.nextInt(counselors.size());
            Group group = new Group(groupNames[i], i + 1, 0,
                    (Counselor) counselors.get(random), (i + 4) * 2 - 1, (i + 4) * 2);
            groups.add(group);
            counselors.remove(random);
        }
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).createSchedule();
        }

    }

    /**
     * Constructor for the camp including the UUID
     * 
     * @param uuid  generated UUID for camp
     * @param date  Start date of camp
     * @param price cost to attend camp
     * @param theme theme of camp
     */
    public Camp(UUID uuid, Date date, String theme, double price,
            ArrayList<Group> groups) {
        this.uuid = uuid;
        this.date = date;
        this.theme = theme;
        this.price = price;
        this.groups = groups;

    }

    /**
     * This method sets the themes to specific themes
     * 
     * @param theme is the theme for each camp
     */
    public void setTheme(String theme) {
        ArrayList<String> themeList = new ArrayList<String>(
                Arrays.asList("Hawaiin", "Rockstars", "Ninja Warriors", "Willy Wonka", "Hollywood",
                        "Legos", "Cops and Robbers", "Shark Tank", "Smores"));
        if (themeList.contains(theme)) {
            this.theme = theme;
        } else {
            this.theme = null;
        }

    }

    /**
     * Returns the camp's ArrayList of type Group
     *
     * @return ArrayList<Group> holds all the groups that are in the camp
     */
    public ArrayList<Group> getGroups() {
        return this.groups;
    }

    /**
     * This method generates the schedule for each group
     */
    public void generateGroupSchedules() {
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).createSchedule();
        }
    }

    public void createGroups() {

    }

    /**
     * Accessor for date
     * 
     * @return date for camp
     */
    public Date getDate() {
        return date;
    }

    /**
     * Accessor for price
     * 
     * @return price for camp
     */
    public double getPrice() {
        return price;
    }

    /**
     * Accessor for theme
     * 
     * @return theme for camp
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Accessor for UUID
     * 
     * @return UUID for camp
     */
    public UUID getUuid() {
        return uuid;
    }

    public String getCounselorSchedule(Counselor counselor){
        for(Group g : groups){
            if(g.getGroupByCounselor(counselor) != null){
                return g.scheduleToString();
            }
        }
        return null;
    }

    /**
     * This method adds a child if they fit into the group
     * 
     * @param child is child for each camp
     */
    public void addChild(Child child) {
        for (Group g : groups) {
            if (g.childFits(child)) {
                g.addChild(child);
            }
        }
    }

    /**
     * This method goes to the specific group and removes the child
     * 
     * @param child is the child for each camp
     */
    public void removeChild(Child child) {
        for (Group g : groups) {
            if (g.getGroupByChild(child) != null) {
                g.removeChild(child);
            }
        }
    }

    /**
     * This method checks and sees if a group has an open spot
     * 
     * @param child child for each camp
     * @return if the camp has a spot for the child
     */
    public boolean hasOpening(Child child) {
        for (Group g : groups) {
            if (g.childFits(child)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method prints out who is in each group
     * 
     * @param user is the counselor user of each camp
     * @return String of who is in the group
     */
    public String viewGroup(Counselor user) {
        Group group = getGroup(user);

        String ret = "";
        ArrayList<Child> children = group.getCampers();
        for (int i = 1; i <= children.size(); i++) {
            ret += i + " - " + children.get(i - 1) + "\n";
        }
        return ret;
    }

    /**
     * This method gets each group by counselor
     * 
     * @param user is the counselor user
     * @return the group for each counselor
     */
    public Group getGroup(Counselor user) {
        for (Group g : groups) {
            if (g.getCounselor().getID().compareTo(user.getID()) == 0) {
                return g;
            }
        }
        return null;
    }

    /**
     * Returns a string that summarizes the important attributes of the camp
     *
     * @return String is a breif description of the camp's data
     */
    public String toString() {
        String pattern = "MM/dd/yyyy";
        return "Camp:" +
                "\n\tDate: " + new SimpleDateFormat(pattern).format(this.date) +
                "\n\tPrice: " + this.price +
                "\n\tTheme: " + this.theme;
    }
}