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
@Table(name = "discipline")
public class SportDiscipline implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disciplineid;

    @ManyToOne
    @JoinColumn(name = "sportid")
    private Sport sport;

    private String name;

    @OneToMany(mappedBy = "wedstrijdid")
    private Set<Wedstrijd> wedstrijd = new HashSet<>();
}
