import java.util.List;

public interface UserDAO {
    User createUser(User user);
    User getById(int id);
    List<User>getAllUser();
    void updateUser(User user);
    void deleteUser(User user);
}
