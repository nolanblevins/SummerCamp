import java.util.ArrayList;
import java.util.Random;
public class Schedule {
    private ArrayList<Activity> schedule;
    private WeekDay day;
    public Schedule(ArrayList<Activity> schedule, WeekDay day) {
        this.schedule = schedule;
        this.day = day;
    }
        
    public Schedule getSchedule(WeekDay weekday) {
        return null;
    }

    public ArrayList<Activity> generateSchedule() {
        new Activity("Breakfast", -1, null, null);
        Random rand;
        ActivityList ActivityList = new ActivityList();
        schedule = new ArrayList<Activity>();
        ActivityList = ActivityList.getInstance();
        ArrayList<Activity> temp = new ArrayList<Activity>();
        temp = ActivityList.getAllActivities();
        
        


        
        new Schedule(schedule, day);
        return null;
    }
    public ArrayList<Activity> generateDailySchedule() {
        return null;
        
    }

    public String toString() {
        return null;
    }

   
    
}
