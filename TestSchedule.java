/**
 * Nolan Blevins
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSchedule{
    private ActivityList activityList = ActivityList.getInstance();
    private ArrayList<Activity> activities = activityList.getAllActivities();
    private Schedule schedule = new Schedule(activities, null);

    @BeforeEach
    public void setup() {
        activities = activityList.getAllActivities();
    }

    @Test
    public void testGetNullSchedule() {
        Schedule schedule = new Schedule(null, null);
        assertEquals(schedule, schedule = new Schedule(null, null));

    }
    @Test
    public void testGetDailySchedule() {
        Schedule testSchedule = schedule.getDailySchedule(WeekDay.MONDAY);
        assertEquals(testSchedule, schedule.getDailySchedule(WeekDay.MONDAY));
    }
    @Test
    public void testGenerateSchedule() {
        ArrayList<Schedule> schedules = schedule.generateSchedule();
        assertEquals(schedule.generateSchedule().size(), schedules.size());
    }
    @Test
    public void testGenerateScheduleWithNullActivityList() {
        activityList.clear();
        schedule.generateSchedule();
        assertEquals(null , schedule.getSchedule());
    }
    @Test
    public void testGenerateScheduleWithOneActivity() {
        activityList.clear();
        Activity activity = new Activity("Swimming", 1, "Swimming in the lake", "Lake");
        activityList.addActivity(activity);
        schedule.generateSchedule();
        assertEquals(activity, schedule.generateSchedule().get(0));
    }
    




    


}
