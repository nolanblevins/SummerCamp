import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
public class Schedule {
    private ArrayList<Activity> schedule;
    private WeekDay day;
    public Schedule(ArrayList<Activity> schedule, WeekDay day) {
        this.schedule = schedule;
        this.day = day;
    }

    public ArrayList<Schedule> generateSchedule() {
        /*
         * Schedule Layout:
         * 8 am - 9 am: wakeup
         * 9 am - 10 am: Breakfast
         * 10 am - 12 pm: activities
         * 12 pm - 1pm: lunch
         * 1 pm - 6pm: activities
         * 6 pm - 7 pm: dinner
         * 7 pm - 9 pm: activities
         * 9 pm - 10 pm : bedtime
         */
        
        new Activity("Breakfast", 1, "Meal eaten in morning", "Dining Hall");
        new Activity("Lunch", 1, "Meal eaten in afternoon", "Dining Hall");
        new Activity("Dinner", 1, "Meal eaten at night", "Dining Hall");
        Random rand = new Random();
        ActivityList ActivityList = new ActivityList();
        ActivityList = ActivityList.getInstance();
        ArrayList<Activity> allActivities = new ArrayList<Activity>();
        allActivities = ActivityList.getAllActivities();
        ArrayList<Schedule> weeklySchedule = new ArrayList<Schedule>();
        for(WeekDay day : WeekDay.values()) {
            ArrayList<Activity> activities = new ArrayList<Activity>();
            activities.add(new Activity("Wakeup", 1, "Children get out of bed and get ready", "Cabin"));
            activities.add( new Activity("Breakfast", 1, "Meal eaten in morning", "Dining Hall"));
            for(int i = 0; i < 3; i++) {
                activities.add(allActivities.get(rand.nextInt(allActivities.size())));
            }
            activities.add(new Activity("Lunch", 1, "Meal eaten in afternoon", "Dining Hall"));
            for(int i = 0; i < 6; i++) {
                activities.add(allActivities.get(rand.nextInt(allActivities.size())));
            }
            activities.add(new Activity("Dinner", 1, "Meal eaten at night", "Dining Hall"));
            for(int i = 0; i < 3; i++) {
                activities.add(allActivities.get(rand.nextInt(allActivities.size())));
            }
            activities.add(new Activity("Bedtime", 1, "Children get ready for and go to bed", "Cabin"));
            Schedule dailySchedule = new Schedule(activities, day);
            weeklySchedule.add(dailySchedule);
        }
        return weeklySchedule;
    }
    public ArrayList<Activity> getDailySchedule(WeekDay weekDay) {
        if(weekDay == WeekDay.SUNDAY) {
            //return weeklySchedule.get(0);
        }
        return null;
        
    }

    public String toString() {
        return null;
    }

   
    
}
