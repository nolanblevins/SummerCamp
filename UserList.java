import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList(){
        this.users = DataReader.loadUsers();
    }

    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }
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


    public User getUser(UUID uuid){
        for(User u : users){
            if(uuid.compareTo(u.getID()) == 0){
                return u;
            }
        }
        return null;
    }

    public void editUser(User user){
        for(User u : users){
            if(user.getID().compareTo(u.getID()) == 0){
                u = user;
                return;
            }
        }
    }

    public void saveUsers(){
        DataWriter.saveUsers();
    }

    public ArrayList<User> getUsersByType(UserType userType){
        ArrayList<User> typeUsers = new ArrayList<>();
        for(User u : this.users){
            if(u.getUserType() == userType){
                typeUsers.add(u);
            }
        }
        return typeUsers;
    }

    
}
