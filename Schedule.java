import java.util.ArrayList;
import java.util.Random;

public class Schedule {
    private ArrayList<Activity> schedule;
    private WeekDay day;

    public Schedule(ArrayList<Activity> schedule, WeekDay day) {
        this.schedule = schedule;
        this.day = day;
    }

    /**
     * @return
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
        ArrayList<Activity> allActivities = activityList.getAllActivities();
        ArrayList<Schedule> weeklySchedule = new ArrayList<Schedule>();
        for (WeekDay day : WeekDay.values()) {
            ArrayList<Activity> activities = new ArrayList<Activity>();

            // 8am - 10am
            activities.add(new Activity("Wakeup", 1, "Children get out of bed and get ready", "Cabin"));
            activities.add(new Activity("Breakfast", 1, "Meal eaten in morning", "Dining Hall"));
            // 10am - 12pm
            for (int i = 0; i < 2; i++) {
                activities.add(allActivities.get(rand.nextInt(allActivities.size())));
            }
            // 12pm - 1pm
            activities.add(new Activity("Lunch", 1, "Meal eaten in afternoon", "Dining Hall"));

            // 1pm - 6pm
            for (int i = 0; i < 5; i++) {
                activities.add(allActivities.get(rand.nextInt(allActivities.size())));
            }
            // 6pm - 7pm
            activities.add(new Activity("Dinner", 1, "Meal eaten at night", "Dining Hall"));

            // 7pm - 9pm
            for (int i = 0; i < 2; i++) {
                activities.add(allActivities.get(rand.nextInt(allActivities.size())));
            }
            // 9pm - 10pm
            activities.add(new Activity("Bedtime", 1, "Children get ready for and go to bed", "Cabin"));
            Schedule dailySchedule = new Schedule(activities, day);
            weeklySchedule.add(dailySchedule);
        }
        return weeklySchedule;
    }

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

    public ArrayList<Activity> getSchedule() {
        return schedule;
    }

    public WeekDay getDay() {
        return day;
    }

    public String toString() {
        return "Schedule:" + schedule + " day:" + day;
    }

}
