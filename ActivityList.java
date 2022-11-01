import java.util.ArrayList;
import java.util.UUID;
/**
 * Class for managing activties from the JSON of activities
 */
public class ActivityList {
    private ArrayList<Activity> activities;
    private static ActivityList activityList;
    /**
     * Constructor for the activity list that loads the activities from
     * the data reader
     */
    private ActivityList() {
        activities = DataReader.loadActivities();
    }

    /**
     * Singleton of the activity list so that 
     * only one list is active at a time
     * 
     * @return a single instamce of the activity list
     */
    public static ActivityList getInstance() {
        if(activityList == null) {
            activityList = new ActivityList();
        }
        return activityList;
    }

    /**
     * Method will add a passed through activity to the local list
     * 
     * @param activity is an activity of the camp
     */
    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    /**
     * Method to get all activities from the list
     * 
     * @return all of the activities of the list
     */
    public ArrayList<Activity> getAllActivities() {
        return this.activities;
    }

    public Activity getActivity(UUID uuid){
        for(Activity activity : activities){
            if(uuid.compareTo(activity.getUuid()) == 0){
                return activity;
            }
        }
        return null;
    }

    public void editActivity(Activity activity) {
        for(Activity a : activities){
            if(activity.getUuid().compareTo(a.getUuid()) == 0){
                a = activity;
                return;
            }
        }
    }

    public void saveActivity() {
        DataWriter.saveActivies();
    }
}
