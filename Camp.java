import java.util.ArrayList;

public class Camp {
    private String time;
    private double price;
    private String theme;
    private ArrayList<Group> groups;
    private ArrayList<Child> children;
    private ArrayList<Counselor> counselors;

    public Camp(String time, double price) {
        this.time = time;
        this.price = price;
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
     * Returns a string that summarizes the important attributes of the camp
     * 
     * @return String   is a breif description of the camp's data
     */
    public String toString() {
        return ("Time: "+ this.time+" Price: "+this.price);
    }
    
    
    
}
