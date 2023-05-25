import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Test {
    static UserDAO userDAO = new UserDAOImpl();
    static RoleDAO roleDAO = new RoleDAOImpl();
    public static void main(String[] args) {
        Roles developer = Roles.builder().type(RoleType.DESIGNER).build();
        Roles analyst = Roles.builder().type(RoleType.ANALYST).build();
        Roles tester = Roles.builder().type(RoleType.TESTER).build();

        roleDAO.create(developer);
        roleDAO.create(analyst);
        roleDAO.create(tester);
        Set<Roles>roles= new HashSet<>();
        roles.add(roleDAO.getById(1));
        User newUser= User.builder()
                .name("Марина")
                .login("NAKAO")
                .password("efe")
                .created(LocalDateTime.now())
                .roles(roles)
                .build();
        User created= userDAO.createUser(newUser);
        roles.add(roleDAO.getById(2));
        created.setRoles(roles);
        userDAO.updateUser(created);
    }

}
