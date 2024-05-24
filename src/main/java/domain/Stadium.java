package domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED )
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
public class Stadium implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadiumid")
    private int id;

    private String name;

    @OneToMany(mappedBy = "stadium")
    private Set<Wedstrijd> wedstrijd = new HashSet<>();
}
