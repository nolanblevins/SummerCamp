import java.util.ArrayList;
public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList(){

    }

    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public void addUser(){

    }

    public User getUser(String email){
        return null;
    }

    public void editUser(User user){

    }

    public void saveUsers(){

    }
}
