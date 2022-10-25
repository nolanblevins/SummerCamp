import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

public class Camp {
    private Date date;
    private double price;
    private String theme;
    private ArrayList<Group> groups;
    private UUID uuid;

    public Camp(Date date, double price) {
        this.date = date;
        this.price = price;
    }

    public Camp(UUID uuid, Date date, String theme, double price,
                ArrayList<Group> groups){
        this.uuid = uuid;
        this.date = date;
        this.theme = theme;
        this.price = price;
        this.groups = groups;
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
        return ("Date: "+ this.date+" Price: "+this.price);
    }
    
    
    
}
