import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "rolers")

public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Role")
    private int id;
    @Enumerated(EnumType.STRING)
    private RoleType type;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "users_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id", referencedColumnName = "id")})
    private Set <User> users= new HashSet<>();

}
