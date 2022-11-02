import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Camp {
    private Date date;
    private double price;
    private String theme;
    private ArrayList<Group> groups;
    private UUID uuid;

    /**
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
        for(int i = 0; i < 6; i++) {
            Group group = new Group(null, i + 1, 0);
            groups.add(group);
        }
        for(int i = 0; i < groups.size(); i++) {
            groups.get(i).createSchedule();
        }
        
    }

    /**
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
    public void setTheme(String theme) {
        ArrayList<String> themeList  = new ArrayList<String>(
                Arrays.asList("Hawaiin", "Rockstars","Ninja Warriors", "Willy Wonka", "Hollywood",
                        "Legos", "Cops and Robbers", "Shark Tank", "Smores"));
        if(themeList.contains(theme)){
            this.theme = theme;
        }
        else{
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
    public void generateGroupSchedules() {
        for(int i = 0; i < groups.size(); i++) {
            groups.get(i).createSchedule();
        }
    }
    public void createGroups() {

    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public String getTheme() {
        return theme;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void addChild(Child child){
        for(Group g : groups){
            if(g.childFits(child)){
                g.addChild(child);
            }
        }
    }

    public void removeChild(Child child){
        for(Group g : groups){
            if(g.getGroupByChild(child) != null){
                g.removeChild(child);
            }
        }
    }

    public boolean hasOpening(Child child){
        for(Group g : groups){
            if(g.childFits(child)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string that summarizes the important attributes of the camp
     *
     * @return String   is a breif description of the camp's data
     */
    public String toString() {
        String pattern = "MM/dd/yyyy";
        return "Camp:" +
                "\n\tDate: " + new SimpleDateFormat(pattern).format(this.date) +
                "\n\tPrice: " + this.price +
                "\n\tTheme: " + this.theme;
    }




}