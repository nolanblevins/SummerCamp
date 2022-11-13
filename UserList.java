import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList(){
        this.users = DataReader.loadUsers();
    }

    /**
     * Returns an instance of the list of users
     * 
     * @return UserList - list of users
     */
    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    /**
     * User will be added to the ArrayList users
     * 
     * @param user  - user to be added to the list
     */
    public void addUser(User user){
        this.users.add(user);
    }

    /**
     * Returns the list of users
     * 
     * @return ArrayList<User>  - list of users
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    /**
     * Returns the user associated with a specifc email and password
     * 
     * @param email - desired user's email
     * @param password  - desired user's password
     * @return User - the specific user with the passed in email and password
     */
    public User getUser(String email, String password){
        for(User u : users){
            if(email.equals(u.getEmail())){
                if(password.equals(u.getPassword())){
                    return u;
                }
            }
        }
        return null;
    }


    /**
     * Returns a user based on their UUID
     * 
     * @param uuid  - desired user's UUID
     * @return User - the specific user with the passed in UUID
     */
    public User getUser(UUID uuid){
        for(User u : users){
            if(uuid.compareTo(u.getID()) == 0){
                return u;
            }
        }
        return null;
    }

    /**
     * Loops through list of users to find the user to be edited
     * 
     * @param user  - the user to be editted
     */
    public void editUser(User user){
        for(User u : users){
            if(user.getID().compareTo(u.getID()) == 0){
                u = user;
                return;
            }
        }
    }

    /**
     * Calls DataWriter to save the users
     */
    public void saveUsers(){
        DataWriter.saveUsers();
    }

    /**
     * Sorts users into a list based off of their user type
     * 
     * @param userType  - the desired userType you're trying to find users of
     * @return ArrayList<User>  - the sorted list of users with the same type
     */
    public ArrayList<User> getUsersByType(UserType userType){
        ArrayList<User> typeUsers = new ArrayList<>();
        for(User u : this.users){
            if(u.getUserType() == userType){
                typeUsers.add(u);
            }
        }
        return typeUsers;
    }

    /**
     * Added for testing
     */
    public void clear(){
        users.clear();
    }

}
