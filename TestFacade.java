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

@BeforeEach
public void setup() {

}


@Test
public void testCreateNullAccount() {
    userList.clear();
    campSystem.createAccount(null, null, null, null, null);
    assertEquals(0, userList.getUsers().size());
}
}