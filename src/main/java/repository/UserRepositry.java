package repository;

import domain.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositry extends CrudRepository<MyUser, Long> {
}
