package repository;

import domain.MyUser;
import domain.Tickets;
import domain.Wedstrijd;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Tickets, Integer> {
    List<Tickets> findTicketsByWedstrijdAndUser(Wedstrijd wedstrijd, MyUser user);
}
