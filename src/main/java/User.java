import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@Getter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_User")
    private int id;
    private String name;
    private String login;
    private String password;
    private LocalDateTime created;
    @ManyToMany
    private Set<Roles> roles=new HashSet<>();

}
