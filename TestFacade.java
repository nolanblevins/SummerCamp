
/**
 * Nolan Blevins
 */

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFacade {
    static CampSystemFacade campSystem = new CampSystemFacade(null, null, null);
    private UserList userList = UserList.getInstance();
    private CampList campList = CampList.getInstance();
    private ActivityList activityList = ActivityList.getInstance();

@BeforeEach
public void setup() {
    UserList.getInstance();
    CampList.getInstance();
    ActivityList.getInstance();
    activityList.clear();
}

@Test
public void testCreateValidAccount() {
    userList.clear();
    campSystem.createAccount("Test", "Test", "555-333-4444", "test@email.com", "password");
    assertEquals(1, userList.getUsers().size());

}
@Test
public void testCreateNullAccount() {
    userList.clear();
    campSystem.createAccount(null, null, null, null, null);
    assertEquals(0, userList.getUsers().size());
}
@Test
public void testCreateAccountWithNullName() {
    userList.clear();
    campSystem.createAccount(null, null, "555-333-4444", "testEmail@email.com", "password");
    assertEquals(0, userList.getUsers().size());
}
@Test
public void testCreateAccountWithNullPhoneNumber() {
    userList.clear();
    campSystem.createAccount("John", "Snow", null, "testEmail@email.com", "password");
    assertEquals(0, userList.getUsers().size());
}
@Test
public void testCreateAccountWithNullEmail() {
    userList.clear();
    campSystem.createAccount("Test", "Test", "555-333-4444", null, "password");
    assertEquals(0, userList.getUsers().size());
}
@Test
public void testCreateAccountWithNullPassword() {
    userList.clear();
    campSystem.createAccount("John", "Snow", "555-333-4444", "testEmail@email.com", null);
    assertEquals(0, userList.getUsers().size());
}

@Test 
public void testCreateValidCamp() {
    campList.clear();
    Date date = new Date(9-23-2022);
    campSystem.createCamp(date, 0, "dogs");
    assertEquals(1, campList.getAllCamps().size());
}
@Test 
public void testCreateNullCamp() {
    campList.clear();
    campSystem.createCamp(null, 0, null);
    assertEquals(0, campList.getAllCamps().size());
}
@Test 
public void testValidDirectorLogin() {
    assertEquals(true, campSystem.loginDirector("JessicaRoberts@xxxxx.com", "7654321"));
}
@Test 
public void testInvalidDirectorLogin() {
    assertEquals(false, campSystem.loginDirector("test@email.com", "11111111"));
}
@Test 
public void testNullDirectorLogin() {
    assertEquals(false, campSystem.loginDirector(null, null));
}
@Test 
public void testValidCounselorLogin() {
    assertEquals(true, campSystem.loginCounselor("BobAller@xxxxx.com", "1234567"));
}
@Test 
public void testInvalidCounselorLogin() {
    assertEquals(false, campSystem.loginCounselor("test@email.com", "1111111"));
}
@Test 
public void testNullCounselorLogin() {
    assertEquals(false, campSystem.loginCounselor(null, null));
}
@Test 
public void testValidRegUserLogin() {
    assertEquals(true, campSystem.loginRegisteredUser("JohnSnow@xxxxx.com", "1234567"));
}
@Test
public void testInvalidRegUserLogin() {
    assertEquals(false, campSystem.loginRegisteredUser("Test@email.com", "1111111"));
}
@Test
public void testNullRegUserLogin() {
    assertEquals(false, campSystem.loginRegisteredUser(null, null));
}
@Test
public void testChangeUserInfoValid() {
        campSystem.createAccount("tomothy", "timberland", "803-867-5309","tomothyTimber@gmail.com" , "tomothyPassword123");
        campSystem.loginRegisteredUser("tomothyTimber@gmail.com", "tomothyPassword123");
        campSystem.changeUserInfo("John", "timberland", "803-867-5309","tomothyTimber@gmail.com" , "tomothyPassword123");
        User user = userList.getUser("tomothyTimber@gmail.com", "tomothyPassword123");
        assertEquals("John", user.getFirstName());
}
@Test
public void testChangeUserInfoNull() {
        campSystem.createAccount("tomothy", "timberland", "803-867-5309","tomothyTimber@gmail.com" , "tomothyPassword123");
        campSystem.loginRegisteredUser("tomothyTimber@gmail.com", "tomothyPassword123");
        campSystem.changeUserInfo(null, "timberland", "803-867-5309","tomothyTimber@gmail.com" , "tomothyPassword123");
        User user = userList.getUser("tomothyTimber@gmail.com", "tomothyPassword123");
        assertEquals("tomothy", user.getFirstName());
}
@Test
public void testChangeUserInfoInvalid() {
        campSystem.createAccount("tomothy", "timberland", "803-867-5309","tomothyTimber@gmail.com" , "tomothyPassword123");
        campSystem.loginRegisteredUser("tomothyTimber@gmail.com", "tomothyPassword123");
        campSystem.changeUserInfo(" ", "timberland", "803-867-5309","tomothyTimber@gmail.com" , "tomothyPassword123");
        User user = userList.getUser("tomothyTimber@gmail.com", "tomothyPassword123");
        assertEquals("tomothy", user.getFirstName());
}
@Test
public void testValidChangeChildInfo() {
    campSystem.loginRegisteredUser("JohnSnow@xxxxx.com", "1234567");
    campSystem.changeChildInfo(0, "tam", "Snow", null);
    Child c = campSystem.getChild(0);
    assertEquals("tam", c.getFirstName());
}
@Test
public void testNullChangeChildInfo() {
    campSystem.loginRegisteredUser("JohnSnow@xxxxx.com", "1234567");
    campSystem.changeChildInfo(0, null, "Snow", null);
    Child c = campSystem.getChild(0);
    assertEquals("Tammy", c.getFirstName());
}
@Test
public void testInvalidChangeChildInfo() {
    campSystem.loginRegisteredUser("JohnSnow@xxxxx.com", "1234567");
    campSystem.changeChildInfo(0, " ", "Snow", null);
    Child c = campSystem.getChild(0);
    assertEquals("Tammy", c.getFirstName());
}
@Test
public void testValidChangeCounselorMedInfo() {
    campSystem.loginCounselor("BobAller@xxxxx.com", "1234567");
        Pediatrician pediatrician = new Pediatrician("FName", "LName",
        "555-444-3333", "Business");
        Contact c = new Contact("f", "l", "555-5555", "cousin");
        ArrayList<Contact> cs = new ArrayList<>();
        cs.add(c);
        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("Peanut");
        ArrayList<String> cond = new ArrayList<>();
        cond.add("ADD");
    MedicalInfo medicalInfo = new MedicalInfo(
        cs,
        "Address",
        allergies,
        cond,
        pediatrician
    );
    campSystem.changeCounselorMedInfo(medicalInfo);
   assertEquals(medicalInfo.toString(), campSystem.getCounselorMedInfo((Counselor) userList.getUser("BobAller@xxxxx.com", "1234567")));
}
@Test
public void testNullChangeCounselorMedInfo() {
    campSystem.loginCounselor("BobAller@xxxxx.com", "1234567");
        Pediatrician pediatrician = new Pediatrician("FName", "LName",
        "555-444-3333", "Business");
        Contact c = new Contact("f", "l", "555-5555", "cousin");
        ArrayList<Contact> cs = new ArrayList<>();
        cs.add(c);
        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("Peanut");
        ArrayList<String> cond = new ArrayList<>();
        cond.add("ADD");
    MedicalInfo medicalInfo = new MedicalInfo(
        null,
        null,
        null,
        null,
        null
    );
    campSystem.changeCounselorMedInfo(medicalInfo);
   assertEquals(medicalInfo.toString(), campSystem.getCounselorMedInfo((Counselor) userList.getUser("BobAller@xxxxx.com", "1234567")));
}
// end of Nolan Blevins testing for facade


@Test
public void TestRegisterChild()
{
    Child child = new Child(null, null, null, null);
    CampList campList = CampList.getInstance();
    ArrayList<Camp> camps = campList.getAllCamps();
    ArrayList<Camp> addCamps = new ArrayList<>();
    addCamps.add(camps.get(0));
    campSystem.registerChild(child,addCamps);
    assertEquals(true, ChildList.getInstance().getChildren().contains(child));
}

@Test 
public void testAddValidActivity(){
    Activity validActivity = new Activity("Magic", 2, "fun", "lake");
    activityList.addActivity(validActivity);
    assertEquals(1, activityList.getAllActivities().size());
}

@Test
public void testAddNullActivity(){
    activityList.addActivity(null);
    assertEquals(0, activityList.getAllActivities().size());
}

}
