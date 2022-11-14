/**
 * Tested by Grant Ward
 */

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRegisteredUser {
   RegisteredUser registeredUser;
    @BeforeEach
   public void setup()
   {
        registeredUser = new RegisteredUser("FName", "Lname", 
        "Email@email.com", "555-444-3333", "password", new ArrayList<Child>());
   }
    @Test
    public void TestRegisterChild()
    {
        registeredUser.registerChild(new Child(null, null, null, null));
        assertEquals(1, registeredUser.getChildren().size());
    }
    
    @Test
    public void TestNullRegisterChild()
    {
        registeredUser.registerChild(null);
        assertEquals(1, registeredUser.getChildren().size());
    }

    @Test
    public void TestRegisterMultipleChildren()
    {
        registeredUser.registerChild(new Child(null, null, null, null));
        registeredUser.registerChild(new Child(null, null, null, null));
        assertEquals(2, registeredUser.getChildren().size());
    }
}
