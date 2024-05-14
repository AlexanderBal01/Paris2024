package repository;

import domain.Sport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SportRepository extends CrudRepository<Sport, Long> {
    List<Sport> findByName(String name);
}