/*
 * Tested by My Tran
 */

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDirector {
    ActivityList activityList = ActivityList.getInstance();
    FAQList faqList = FAQList.getInstance();

    @BeforeEach
    public void setup() {
        activityList.clear();
    }

    @Test
    public void testaddValidActivity(){
        Activity validActivity;
        validActivity = new Activity("Title", 2, "description", "location");
        activityList.addActivity(validActivity);
        assertEquals(1, activityList.getAllActivities().size());
    }

    @Test
    public void testaddNullActivity(){
        activityList.addActivity(null);
        assertEquals(0, activityList.getAllActivities().size());
        
    }

    @Test
    public void testaddMultipleActivity(){
        Activity activity1 = new Activity("1", 2, "3", "4");
        Activity activity2 = new Activity("5", 6, "7", "8");
        activityList.addActivity(activity1);
        activityList.addActivity(activity2);
        assertEquals(2, activityList.getAllActivities().size());
    }
    @Test
    public void testaddValidFAQ(){
        FAQ validFaq = new FAQ("hi","how are you");
        faqList.addFAQ(validFaq);
        assertEquals(1, faqList.getFaqs().size());
    }

    @Test
    public void testaddNullFAQ(){
        faqList.addFAQ(null);
        assertEquals(0, faqList.getFaqs().size());

    }
}

