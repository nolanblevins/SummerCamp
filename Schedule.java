import java.util.ArrayList;
import java.util.Random;
import java.util.Formatter;  

public class Schedule {
    private ArrayList<Activity> schedule;
    private WeekDay day;

    /**
     * This method is a Constructor for Schedule
     * @param schedule      schedule
     * @param day           enum Days Of Week
        */
    public Schedule(ArrayList<Activity> schedule, WeekDay day) {
        this.schedule = schedule;
        this.day = day;
    }

    /**
     * This method generate a Schedule with random Activity
     * 
     * @return weeklySchedule 
     * 
     */
    public ArrayList<Schedule> generateSchedule() {
        /*
         * Schedule Layout:
         * 8 am - 9 am: wakeup
         * 9 am - 10 am: Breakfast
         * 10 am - 12 pm: activities
         * 12 pm - 1pm: lunch
         *
         * 1 pm - 6pm: activities
         * 6 pm - 7 pm: dinner
         * 7 pm - 9 pm: activities
         * 9 pm - 10 pm : bedtime
         */
        Random rand = new Random();
        ActivityList activityList = ActivityList.getInstance();

        ArrayList<Schedule> weeklySchedule = new ArrayList<Schedule>();
        for (WeekDay day : WeekDay.values()) {
            ArrayList<Activity> allActivities = new ArrayList<>();
            for(Activity a : activityList.getAllActivities()){
                allActivities.add(a);
            }
            ArrayList<Activity> activities = new ArrayList<Activity>();

            // 8am - 10am
            activities.add(activityList.getWakeup());
            activities.add(activityList.getBreakFast());
            // 10am - 12pm
            for (int i = 0; i < 2; i++) {
                int randInt = rand.nextInt(allActivities.size());
                activities.add(allActivities.get(randInt));
                allActivities.remove(randInt);
            }
            // 12pm - 1pm
            activities.add(activityList.getLunch());

            // 1pm - 6pm
            for (int i = 0; i < 5; i++) {
                int randInt = rand.nextInt(allActivities.size());
                activities.add(allActivities.get(randInt));
                allActivities.remove(randInt);            
            }
            // 6pm - 7pm
            activities.add(activityList.getDinner());

            // 7pm - 9pm
            for (int i = 0; i < 2; i++) {
                int randInt = rand.nextInt(allActivities.size());
                activities.add(allActivities.get(randInt));
                allActivities.remove(randInt);            
            }
            // 9pm - 10pm
            activities.add(activityList.getBedTime());
            Schedule dailySchedule = new Schedule(activities, day);
            weeklySchedule.add(dailySchedule);
        }
        return weeklySchedule;
    }
    
    /**
     * This method returns dailySchedule from a WeeklySchedule
     * @return      dailySchedule
        */
    public Schedule getDailySchedule(WeekDay weekDay) {
        ArrayList<Schedule> weeklySchedule = new ArrayList<Schedule>();
        Schedule dailySchedule = new Schedule(schedule, weekDay);
        weeklySchedule = generateSchedule();
        if (weekDay == WeekDay.SUNDAY) {
            dailySchedule = weeklySchedule.get(0);
        }
        if (weekDay == WeekDay.MONDAY) {
            dailySchedule = weeklySchedule.get(1);
        }
        if (weekDay == WeekDay.TUESDAY) {
            dailySchedule = weeklySchedule.get(2);
        }
        if (weekDay == WeekDay.WEDNESDAY) {
            dailySchedule = weeklySchedule.get(3);
        }
        if (weekDay == WeekDay.THURSDAY) {
            dailySchedule = weeklySchedule.get(4);
        }
        if (weekDay == WeekDay.FRIDAY) {
            dailySchedule = weeklySchedule.get(5);
        }
        if (weekDay == WeekDay.SATURDAY) {
            dailySchedule = weeklySchedule.get(6);
        }
        return dailySchedule;

    }
    /**
     * Accessor for Schedule
     * @return      schedule
        */
    public ArrayList<Activity> getSchedule() {
        return schedule;
    }

    /**
     * Accessor for Weekday
     * @return      day
        */
    public WeekDay getDay() {
        return day;
    }
    
    /**
     * This method returns all the Schedule parameters in a String
     * @return     String   schedule properties'
    */
    public String toString() {
        /* 
        String ret = "";
        for(int i = 0; i < schedule.size(); i++) {
            ret += "day: "+day + "\n\t";
            ret += "Schedule: "+schedule.get(i);
        }
        return ret;
        */


        String[] activities = new String[schedule.size()];
        String[] location = new String[schedule.size()];

        schedule.get(0).getTitle();

        Formatter fmt = new Formatter();
        fmt.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10\n",
                "Time", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        fmt.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", schedule.get(0).getTitle(), schedule.get(1).getTitle(), schedule.get(2).getTitle(), schedule.get(3).getTitle(), schedule.get(4).getTitle(),
        schedule.get(5).getTitle(), schedule.get(6).getTitle(), schedule.get(7).getTitle(), schedule.get(8).getTitle(), schedule.get(9).getTitle(), schedule.get(10).getTitle(), schedule.get(11).getTitle(), schedule.get(12).getTitle(), 
        schedule.get(13).getTitle());

        fmt.format( "%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", schedule.get(0).getLocation(), schedule.get(1).getLocation(), schedule.get(2).getLocation(), schedule.get(3).getLocation(), schedule.get(4).getLocation(), 
        schedule.get(5).getLocation(), schedule.get(6).getLocation(), schedule.get(7).getLocation(), schedule.get(8).getLocation(), schedule.get(9).getLocation(), schedule.get(10).getLocation(), schedule.get(11).getLocation(), schedule.get(12).getLocation(), 
        schedule.get(13).getLocation());

        return fmt.toString();

    }

}
