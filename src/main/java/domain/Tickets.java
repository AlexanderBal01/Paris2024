package domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED )
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
public class Tickets implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketid")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private MyUser user;

    @ManyToOne
    @JoinColumn(name = "wedstrijdid")
    private Wedstrijd wedstrijd;
}
