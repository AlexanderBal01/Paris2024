package repository;

import domain.Stadium;
import org.springframework.data.repository.CrudRepository;

public interface StadiumRepository extends CrudRepository<Stadium, Long> {
    Stadium findByName(String name);
}
