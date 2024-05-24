package repository;

import domain.Sport;
import domain.SportDiscipline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SportDisciplineRepository extends CrudRepository<SportDiscipline, Long> {
    List<SportDiscipline> findBySport(Sport sport);
    SportDiscipline findByName(String name);
}
