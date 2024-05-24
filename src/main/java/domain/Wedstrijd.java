package domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class Wedstrijd implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wedstrijdid;

    @ManyToOne
    @JoinColumn(name = "stadiumid")
    private Stadium stadium;

    private int aantalPlaatsen;

    private int aantalBezettePlaatsen;

    private LocalDate datum;

    private LocalTime startUur;

    private double prijs;

    @ManyToOne
    @JoinColumn(name = "disciplineid")
    private SportDiscipline discipline;

    @ManyToOne
    @JoinColumn(name = "sportid")
    private Sport sport;

    @OneToMany(mappedBy = "wedstrijd")
    private Set<Tickets> tickets = new HashSet<>();

}
