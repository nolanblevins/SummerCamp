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

@BeforeEach
public void setup() {
    UserList.getInstance();
    CampList.getInstance();

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
    User user1 = new User("tomothy", "timberland", "tomothyTimber@gmail.com", "803-867-5309", "tomothyPassword123");
    userList.addUser(user1);
        campSystem.loginRegisteredUser(null, null)
        assertEquals("tomothy", user1.getFirstName());
    assertEquals(null, null);
}

}