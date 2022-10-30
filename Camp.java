import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

public class Camp {
    // add array of themes
    /**
    * Hawaiin
    * Rockstars
    * Ninja Warriors
    * Willy Wonka
    * Hollywood
    * Legos
    * Cops and Robbers
    * Shark Tank
    * Smores
    */
    private Date date;
    private double price;
    private String theme;
    private ArrayList<Group> groups;
    private UUID uuid;

    /**
     * @param date Start date of camp
     * @param price cost to attend camp
     * @param theme theme of camp
     */
    public Camp(Date date, double price, ArrayList<String> theme) {
    public Camp(Date date, double price, String theme) {
        this.date = date;
        this.price = price;
        this.theme = theme;
    }
    /**
     * @param UUID generated UUID for camp
     * @param date Start date of camp
     * @param price cost to attend camp
     * @param theme theme of camp
     */
    public Camp(UUID uuid, Date date, ArrayList<String> theme, double price,

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

    /**
     * Returns a string that summarizes the important attributes of the camp
     * 
     * @return String   is a breif description of the camp's data
     */
    public String toString() {
        return ("Date: "+ this.date+" Price: "+this.price);
    }
    
    
    
}
