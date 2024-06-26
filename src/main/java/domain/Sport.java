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
public class Sport implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sportid;

    private String name;

    private String imageDescription;

    private String imageLocation;

    @OneToMany(mappedBy = "sport")
    private Set<SportDiscipline> disciplines = new HashSet<>();

    @OneToMany(mappedBy = "sport")
    private Set<Wedstrijd> sporten = new HashSet<>();
}
