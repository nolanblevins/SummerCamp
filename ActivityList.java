import java.util.ArrayList;
import java.util.UUID;

public class ActivityList {
    private ArrayList<Activity> activities;
    private static ActivityList activityList;

    private ActivityList() {
        activities = DataReader.loadActivities();
    }

    public static ActivityList getInstance() {
        if(activityList == null) {
            activityList = new ActivityList();
        }
        return activityList;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

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