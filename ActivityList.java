import java.util.ArrayList;

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


    }

    public ArrayList<Activity> getAllActivities() {
        return this.activities;
    }

    public void editActivity(Activity activity) {

    }

    public void saveActivity() {

    }
}
