package domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED )
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
@Table(name = "user")
public class MyUser implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullname;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role role;

    public MyUser(String username, String password, String fullname, Role role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }
}
