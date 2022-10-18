import java.util.UUID;
public class Director extends User{

    private UUID id;

    public Director(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = UUID.randomUUID();
    }

    public Director(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        this.id = id;
    }
    
}
