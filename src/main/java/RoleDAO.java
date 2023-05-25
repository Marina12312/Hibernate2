import java.util.List;

public interface RoleDAO {
    void create(Roles roles);
    Roles getById(int id);
    List<Roles>getAllRoles();
    void delete(Roles roles);

}
