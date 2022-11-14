/*
 * Tested by Jonah Andrews
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class TestUser {

    @BeforeEach
    public void setup() {
        //User user1 = new User("tomothy", "timberland", "tomothyTimber@gmail.com", "803-867-5309", "tomothyPassword123");
    }
    
    @Test
    public void changeUserWithAllNullValuesTest() {
        User user1 = new User("tomothy", "timberland", "tomothyTimber@gmail.com", "803-867-5309", "tomothyPassword123");
        user1.changeInfo(null, null, null, null, null);
        assertEquals("tomothy", user1.getFirstName());
    }

    @Test
    public void changeUserWithNullValuesTest() {
        User user1 = new User("tomothy", "timberland", "tomothyTimber@gmail.com", "803-867-5309", "tomothyPassword123");
        user1.changeInfo("chadwhick", null, null, null, null);
        assertEquals("chadwhick", user1.getFirstName());
    }

    @Test
    public void changeUserWithAllNonNullValuesTest() {
        User user1 = new User("tomothy", "timberland", "tomothyTimber@gmail.com", "803-867-5309", "tomothyPassword123");
        user1.changeInfo("tim", "timber", "555-554-3342", "timtimber@gmail.com", "passthatword123");
        assertEquals("tim", user1.getFirstName());
    }

    @Test
    public void changeUserToSameValuesTest() {
        User user1 = new User("tomothy", "timberland", "tomothyTimber@gmail.com", "803-867-5309", "tomothyPassword123");
        user1.changeInfo("tomothy", "timberland", "tomothyTimber@gmail.com", "803-867-5309", "tomothyPassword123");
        assertEquals("tomothy",user1.getFirstName());
    }

}
