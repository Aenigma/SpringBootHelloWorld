package demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Kevin
 */
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);
}
