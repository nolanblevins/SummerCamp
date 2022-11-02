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

    public Activity getWakeup(){
        for(Activity a : activities){
            if(a.getUuid().compareTo(UUID.fromString("6140890d-2586-4d81-85ca-e894f5179795")) == 0){
                return a;
            }
        }
        return null;
    }

    public Activity getBreakFast(){
        for(Activity a : activities){
            if(a.getUuid().compareTo(UUID.fromString("11b7bd9c-59c9-450f-ba96-0c44f970ffa3")) == 0){
                return a;
            }
        }
        return null;
    }

    public Activity getLunch(){
        for(Activity a : activities){
            if(a.getUuid().compareTo(UUID.fromString("4e901f3d-b1e6-4632-91fd-8a200f3dba02")) == 0){
                return a;
            }
        }
        return null;
    }

    public Activity getDinner(){
        for(Activity a : activities){
            if(a.getUuid().compareTo(UUID.fromString("aa389f82-b7f5-4276-aa1b-d107a79137a6")) == 0){
                return a;
            }
        }
        return null;
    }

    public Activity getBedTime(){
        for(Activity a : activities){
            if(a.getUuid().compareTo(UUID.fromString("64702f3a-45ee-4b26-acd7-37e210495240")) == 0){
                return a;
            }
        }
        return null;
    }
}