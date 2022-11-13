/**
 * Tested by Matthew Hughes
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestActivityList {
    ActivityList activityList = ActivityList.getInstance();
    ArrayList<Activity> activities = new ArrayList<>();

    @BeforeEach
    public void setup(){
        activityList.clear();
        activities.add(new Activity("A1", 1, "Activity 1", "Location 1"));
        activities.add(new Activity("A2", 1, "Activity 2", "Location 2"));
        activityList.addActivity(activities.get(0));
        activityList.addActivity(activities.get(1));
    }

    @Test
    public void testAddActivity(){
        activityList.addActivity(new Activity("A3", 1, "Activity 3", "Location 3"));
        assertEquals(3, activityList.getAllActivities().size());
    }

    @Test
    public void testEmptyAddActivity(){
        activityList.clear();
        activityList.addActivity(new Activity("A1", 1, "Activity 1", "Location 1"));
        assertEquals(1, activityList.getAllActivities().size());
    }

    @Test
    public void testNullAddActivity(){
        activityList.addActivity(null);
        assertEquals(2, activityList.getAllActivities().size());
    }

    @Test
    public void testDuplicateAddActivity(){
        Activity testActivity = activityList.getAllActivities().get(0);
        activityList.addActivity(testActivity);
        assertEquals(2, activityList.getAllActivities().size());
    }

    @Test
    public void testGetActivityUUID(){
        Activity testActivity = activityList.getAllActivities().get(0);
        Activity activity = activityList.getActivity(testActivity.getUuid());
        assertEquals(testActivity, activity);
    }

    @Test
    public void testGetActivityNullUUID(){
         Activity activity = activityList.getActivity(null);
         assertEquals(null, activity);
    }

    @Test
    public void testGetActivityMissingUUID(){
        Activity activity = activityList.getActivity(UUID.randomUUID());
        assertEquals(null, activity);
    }

    @Test
    public void testClear(){
        activityList.clear();
        assertEquals(0, activityList.getAllActivities().size());
    }
}
