/**
 * Tested by Matthew Hughes
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class TestUserList {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = new ArrayList<>();

    @BeforeEach
    public void setup(){
        userList.clear();
        users.add(new User("Matt", "Hughes", "msh17@email.com",
                "555-444-3333", "password"));
        users.add(new User("Jonah", "Andrews", "jAndrews@email.com",
                "555-333-4444", "password"));
        userList.addUser(users.get(0));
        userList.addUser(users.get(1));
    }

    @Test
    public void testAddUser(){
        userList.addUser(new User("Grant", "Ward", "gWard@email.com",
                "555-333-4444", "password"));
        assertEquals(3, userList.getUsers().size());
    }

    @Test
    public void testEmptyAddUser(){
        userList.clear();
        userList.addUser(new User("Grant", "Ward", "gWard@email.com",
                "555-333-4444", "password"));
        assertEquals(1, userList.getUsers().size());
    }

    @Test
    public void testNullAddUser(){
        userList.addUser(null);
        assertEquals(2, userList.getUsers().size());
    }

    @Test
    public void testDuplicateAddUser(){
        User user = userList.getUsers().get(0);
        userList.addUser(user);
        assertEquals(2, userList.getUsers().size());
    }

    @Test
    public void testGetUserEmailPassword(){
        User user = userList.getUser("msh17@email.com", "password");
        User testUser = users.get(0);
        assertEquals(0, user.getID().compareTo(testUser.getID()));
    }

    @Test
    public void testBadEmailGetUserEmailPassword(){
        User user = userList.getUser("msh17@com", "password");
        assertEquals(null, user);
    }

    @Test
    public void testBadPasswordGetUserEmailPassword(){
        User user = userList.getUser("msh17@email.com", "12345");
        assertEquals(null, user);
    }

    @Test
    public void testGetUserEmptyEmailPassword(){
        User user = userList.getUser("", "password");
        assertEquals(null, user);
    }

    @Test
    public void testGetUserEmailEmptyPassword(){
        User user = userList.getUser("msh17@email.com", "");
        assertEquals(null, user);
    }

    @Test
    public void testGetUserNullEmailPassword(){
        User user = userList.getUser(null, "password");
        assertEquals(null, user);
    }

    @Test
    public void testGetUserEmailNullPassword(){
        User user = userList.getUser("msh17@email.com", null);
        assertEquals(null, user);
    }

    @Test
    public void testGetUserUUID(){
        User testUser = users.get(0);
        User user = userList.getUser(testUser.getID());
        assertEquals(0, user.getID().compareTo(testUser.getID()));
    }

    @Test
    public void testGetUserMissingUUID(){
        User user = userList.getUser(UUID.randomUUID());
        assertEquals(null, user);
    }

    @Test
    public void testGetUserNullUUID(){
        User user = userList.getUser(null);
        assertEquals(null, user);
    }

    @Test
    public void testClear(){
        userList.clear();
        assertEquals(0, userList.getUsers().size());
    }

    @Test
    public void testGetUserByTypeCounselor(){
        userList.clear();
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new Director(null, null, null, null, null));

        assertEquals(3, userList.getUsersByType(UserType.COUNSELOR).size());
    }

    @Test
    public void testGetUserByTypeNoCounselor(){
        userList.clear();
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new Director(null, null, null, null, null));

        assertEquals(0, userList.getUsersByType(UserType.COUNSELOR).size());
    }

    @Test
    public void testGetUserByTypeRU(){
        userList.clear();
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new Director(null, null, null, null, null));

        assertEquals(2, userList.getUsersByType(UserType.REGISTERED_USER).size());
    }

    @Test
    public void testGetUserByTypeNoRU(){
        userList.clear();
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Director(null, null, null, null, null));

        assertEquals(0, userList.getUsersByType(UserType.REGISTERED_USER).size());
    }

    @Test
    public void testGetUserByTypeDirector(){
        userList.clear();
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new Director(null, null, null, null, null));

        assertEquals(1, userList.getUsersByType(UserType.DIRECTOR).size());
    }

    @Test
    public void testGetUserByTypeNoDirector(){
        userList.clear();
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));

        assertEquals(0, userList.getUsersByType(UserType.DIRECTOR).size());
    }

    @Test
    public void testGetUserByTypeEmpty(){
        userList.clear();
        int totalSize = userList.getUsersByType(UserType.REGISTERED_USER).size() +
                userList.getUsersByType(UserType.COUNSELOR).size() +
                userList.getUsersByType(UserType.DIRECTOR).size();

        assertEquals(0, totalSize);
    }

    @Test
    public void testGetUserByTypeNull(){
        userList.clear();
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new Counselor(null, null, null,
                null, null, null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));
        userList.addUser(new RegisteredUser(null, null, null,
                null, null));

        assertEquals(0, userList.getUsersByType(null).size());
    }
}
