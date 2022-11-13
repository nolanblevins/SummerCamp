/**
 * Tested by Matthew Hughes
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import java.util.Date;

public class TestDataReaderWriter {
    private UserList userList = UserList.getInstance();
    private GroupList groupList = GroupList.getInstance();
    private CampList campList = CampList.getInstance();
    private ActivityList activityList = ActivityList.getInstance();
    private ChildList childList = ChildList.getInstance();
    private FAQList faqList = FAQList.getInstance();

    @Test
    public void testWritingZeroUsers(){
        userList.clear();
        DataWriter.saveUsersTest();
        assertEquals(0, DataReader.loadUsersTest().size());
    }

    @Test
    public void testWritingOneUser(){
        userList.clear();
        userList.addUser(new RegisteredUser("UserA", "Test", "test",
                "test", "test"));
        DataWriter.saveUsersTest();
        assertEquals("UserA", DataReader.loadUsersTest().get(0).getFirstName());
    }

    @Test
    public void testWritingFiveUsers(){
        userList.clear();
        userList.addUser(new RegisteredUser("UserA", "Test", "test",
                "test", "test"));
        userList.addUser(new Director("UserB", "Test", "test",
                "test", "test"));
        userList.addUser(new RegisteredUser("UserC", "Test", "test",
                "test", "test"));
        userList.addUser(new RegisteredUser("UserD", "Test", "test",
                "test", "test"));
        userList.addUser(new RegisteredUser("UserE", "Test", "test",
                "test", "test"));
        DataWriter.saveUsersTest();
        assertEquals("UserE", DataReader.loadUsersTest().get(4).getFirstName());
    }

    @Test
    public void testWritingUserNullAttributes(){
        userList.clear();
        userList.addUser(new RegisteredUser("UserA", "Test", "test",
                "test", null));
        DataWriter.saveUsersTest();
        assertEquals("UserA", DataReader.loadUsersTest().get(0).getFirstName());
    }

    @Test
    public void testWritingCounselorNullBirthday(){
        userList.clear();
        userList.addUser(new Counselor("UserA", null, null,
                null, null, null, null));
        DataWriter.saveUsersTest();
        assertEquals("UserA", DataReader.loadUsersTest().get(0).getFirstName());
    }

    @Test
    public void testWritingCounselorNullMedInfo(){
        userList.clear();
        userList.addUser(new Counselor("UserA", null, null,
                null, null, new Date(), null));
        DataWriter.saveUsersTest();
        assertEquals("UserA", DataReader.loadUsersTest().get(0).getFirstName());
    }

    @Test
    public void testWritingZeroGroups(){
        userList.clear();
        DataWriter.saveGroupsTest();
        assertEquals(0, DataReader.loadGroupsTest().size());
    }

    @Test
    public void testWritingOneGroups(){
        groupList.clear();
        Camp camp = new Camp(new Date(), 255.99, "Theme");
        Group group = camp.getGroups().get(0);
        groupList.addGroup(group);
        DataWriter.saveGroupsTest();
        assertEquals("Vipers", DataReader.loadGroupsTest().get(0).getGroupName());
    }

    @Test
    public void testWritingSixGroups(){
        groupList.clear();
        Camp camp = new Camp(new Date(), 255.99, "Theme");
        for(Group g : camp.getGroups()) {
            groupList.addGroup(g);
        }
        DataWriter.saveGroupsTest();
        assertEquals("Wildcats", DataReader.loadGroupsTest().get(5).getGroupName());
    }

    @Test
    public void testWritingGroupOutsideCamp(){
        groupList.clear();
        Group group = new Group("", 5, 0,
                new Counselor(null, null, null, null, null, null, null),
                10, 11);
        groupList.addGroup(group);
        DataWriter.saveGroupsTest();
        assertEquals("", DataReader.loadGroupsTest().get(0).getGroupName());
    }

    @Test
    public void testWritingZeroCamps(){
        campList.clear();
        DataWriter.saveCampsTest();
        assertEquals(0, DataReader.loadCampsTest().size());
    }

    @Test
    public void testWritingOneCamp(){
        campList.clear();
        campList.addCamp(new Camp(new Date(),255.99, "ThemeA"));
        DataWriter.saveCampsTest();
        assertEquals("ThemeA", DataReader.loadCampsTest().get(0).getTheme());
    }

    @Test
    public void testWritingFiveCamps(){
        campList.clear();
        campList.addCamp(new Camp(new Date(),255.99, "ThemeA"));
        campList.addCamp(new Camp(new Date(),255.99, "ThemeA"));
        campList.addCamp(new Camp(new Date(),255.99, "ThemeA"));
        campList.addCamp(new Camp(new Date(),255.99, "ThemeA"));
        campList.addCamp(new Camp(new Date(),255.99, "ThemeE"));
        DataWriter.saveCampsTest();
        assertEquals("ThemeE", DataReader.loadCampsTest().get(4).getTheme());
    }

    @Test
    public void testWritingCampBlankTheme(){
        campList.clear();
        campList.addCamp(new Camp(new Date(),255.99, ""));
        DataWriter.saveCampsTest();
        assertEquals("", DataReader.loadCampsTest().get(0).getTheme());
    }

    @Test
    public void testWritingCampNullTheme(){
        campList.clear();
        campList.addCamp(new Camp(new Date(),255.99, null));
        DataWriter.saveCampsTest();
        assertEquals(null, DataReader.loadCampsTest().get(0).getTheme());
    }

    @Test
    public void testWritingCampNullDate(){
        campList.clear();
        campList.addCamp(new Camp(null,255.99, "ThemeA"));
        DataWriter.saveCampsTest();
        assertEquals("ThemeA", DataReader.loadCampsTest().get(0).getTheme());
    }

    @Test
    public void testWritingZeroFAQs(){
        faqList.clear();
        DataWriter.saveFAQsTest();
        assertEquals(0, DataReader.loadFAQsTest().size());
    }

    @Test
    public void testWritingOneFAQs(){
        faqList.clear();
        faqList.addFAQ(new FAQ("Question", "Answer"));
        DataWriter.saveFAQsTest();
        assertEquals("Question", DataReader.loadFAQsTest().get(0).getQuestion());
    }

    @Test
    public void testWritingFiveFAQs(){
        faqList.clear();
        faqList.addFAQ(new FAQ("Question1", "Answer"));
        faqList.addFAQ(new FAQ("Question2", "Answer"));
        faqList.addFAQ(new FAQ("Question3", "Answer"));
        faqList.addFAQ(new FAQ("Question4", "Answer"));
        faqList.addFAQ(new FAQ("Question5", "Answer"));
        DataWriter.saveFAQsTest();
        assertEquals("Question5", DataReader.loadFAQsTest().get(4).getQuestion());
    }

    @Test
    public void testWritingFAQBlankQuestion(){
        faqList.clear();
        faqList.addFAQ(new FAQ("", "Answer"));
        DataWriter.saveFAQsTest();
        assertEquals("", DataReader.loadFAQsTest().get(0).getQuestion());
    }

    @Test
    public void testWritingFAQBlankAnswer(){
        faqList.clear();
        faqList.addFAQ(new FAQ("Question", ""));
        DataWriter.saveFAQsTest();
        assertEquals("", DataReader.loadFAQsTest().get(0).getAnswer());
    }

    @Test
    public void testWritingFAQNullQuestion(){
        faqList.clear();
        faqList.addFAQ(new FAQ(null, "Answer"));
        DataWriter.saveFAQsTest();
        assertEquals(null, DataReader.loadFAQsTest().get(0).getQuestion());
    }

    @Test
    public void testWritingFAQNullAnswer(){
        faqList.clear();
        faqList.addFAQ(new FAQ("Question", null));
        DataWriter.saveFAQsTest();
        assertEquals(null, DataReader.loadFAQsTest().get(0).getAnswer());
    }

    @Test
    public void testWritingZeroActivities(){
        activityList.clear();
        DataWriter.saveActiviesTest();
        assertEquals(0, DataReader.loadActivitiesTest().size());
    }

    @Test
    public void testWritingOneActivities(){
        activityList.clear();
        activityList.addActivity(new Activity("Title1", 1, "Description", "Location"));
        DataWriter.saveActiviesTest();
        assertEquals("Title1", DataReader.loadActivitiesTest().get(0).getTitle());
    }

    @Test
    public void testWritingFiveActivities(){
        activityList.clear();
        activityList.addActivity(new Activity("Title1", 1, "Description", "Location"));
        activityList.addActivity(new Activity("Title1", 1, "Description", "Location"));
        activityList.addActivity(new Activity("Title1", 1, "Description", "Location"));
        activityList.addActivity(new Activity("Title1", 1, "Description", "Location"));
        activityList.addActivity(new Activity("Title5", 1, "Description", "Location"));
        DataWriter.saveActiviesTest();
        assertEquals("Title5", DataReader.loadActivitiesTest().get(4).getTitle());
    }

    @Test
    public void testWritingActivityBlankTitle(){
        activityList.clear();
        activityList.addActivity(new Activity("", 1, "Description", "Location"));
        DataWriter.saveActiviesTest();
        assertEquals("", DataReader.loadActivitiesTest().get(0).getTitle());
    }

    @Test
    public void testWritingActivityBlankDescription(){
        activityList.clear();
        activityList.addActivity(new Activity("Title1", 1, "", "Location"));
        DataWriter.saveActiviesTest();
        assertEquals("", DataReader.loadActivitiesTest().get(0).getDescription());
    }

    @Test
    public void testWritingActivityBlankLocation(){
        activityList.clear();
        activityList.addActivity(new Activity("Title1", 1, "Description", ""));
        DataWriter.saveActiviesTest();
        assertEquals("", DataReader.loadActivitiesTest().get(0).getLocation());
    }

    @Test
    public void testWritingActivityNullTitle(){
        activityList.clear();
        activityList.addActivity(new Activity(null, 1, "Description", "Location"));
        DataWriter.saveActiviesTest();
        assertEquals(null, DataReader.loadActivitiesTest().get(0).getTitle());
    }

    @Test
    public void testWritingActivityNullDescription(){
        activityList.clear();
        activityList.addActivity(new Activity("Title1", 1, null, "Location"));
        DataWriter.saveActiviesTest();
        assertEquals(null, DataReader.loadActivitiesTest().get(0).getDescription());
    }

    @Test
    public void testWritingActivityNullLocation(){
        activityList.clear();
        activityList.addActivity(new Activity("Title1", 1, "Description", null));
        DataWriter.saveActiviesTest();
        assertEquals(null, DataReader.loadActivitiesTest().get(0).getLocation());
    }

    @Test
    public void testWritingZeroChildren(){
        childList.clear();
        DataWriter.saveChildrenTest();
        assertEquals(0, DataReader.loadChildTest().size());
    }

    @Test
    public void testWritingOneChild(){
        childList.clear();
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                new Pediatrician(null, null, null, null));
        childList.addChild(new Child("Name1", "last", medicalInfo, new Date()));
        DataWriter.saveChildrenTest();
        assertEquals("Name1", DataReader.loadChildTest().get(0).getFirstName());
    }

    @Test
    public void testWritingFiveChild(){
        childList.clear();
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                new Pediatrician(null, null, null, null));
        childList.addChild(new Child("Name1", "last", medicalInfo, new Date()));
        childList.addChild(new Child("Name1", "last", medicalInfo, new Date()));
        childList.addChild(new Child("Name1", "last", medicalInfo, new Date()));
        childList.addChild(new Child("Name1", "last", medicalInfo, new Date()));
        childList.addChild(new Child("Name5", "last", medicalInfo, new Date()));
        DataWriter.saveChildrenTest();
        assertEquals("Name5", DataReader.loadChildTest().get(4).getFirstName());
    }

    @Test
    public void testWritingChildBlankFirstName(){
        childList.clear();
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                new Pediatrician(null, null, null, null));
        childList.addChild(new Child("", "last", medicalInfo, new Date()));
        DataWriter.saveChildrenTest();
        assertEquals("", DataReader.loadChildTest().get(0).getFirstName());
    }

    @Test
    public void testWritingChildBlankLastName(){
        childList.clear();
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                new Pediatrician(null, null, null, null));
        childList.addChild(new Child("Name1", "", medicalInfo, new Date()));
        DataWriter.saveChildrenTest();
        assertEquals("", DataReader.loadChildTest().get(0).getLastName());
    }

    @Test
    public void testWritingChildNullMedInfo(){
        childList.clear();
        childList.addChild(new Child("Name1", "last", null, new Date()));
        DataWriter.saveChildrenTest();
        assertEquals(null, DataReader.loadChildTest().get(0).getMedInfo());
    }

    @Test
    public void testWritingChildNullDate(){
        childList.clear();
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                new Pediatrician(null, null, null, null));
        childList.addChild(new Child("Name1", "last", medicalInfo, null));
        DataWriter.saveChildrenTest();
        assertEquals(null, DataReader.loadChildTest().get(0).getBirthday());
    }
}
