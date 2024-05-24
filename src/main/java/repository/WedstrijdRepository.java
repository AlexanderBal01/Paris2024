package repository;

import domain.Sport;
import domain.Wedstrijd;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WedstrijdRepository extends CrudRepository<Wedstrijd, Long> {
    List<Wedstrijd> findAllBySport(Sport sport);
}
