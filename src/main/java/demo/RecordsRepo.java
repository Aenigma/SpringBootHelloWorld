package demo;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Kevin
 */
public interface RecordsRepo extends CrudRepository<Record, Long> {

}
