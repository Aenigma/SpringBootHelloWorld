package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Kevin
 */
@RestController
@RequestMapping(value = "/records")
public class RecordsController {

    //private final Map<Long, Record> mi = new HashMap<>();
    //private final AtomicLong counter = new AtomicLong();

    @Autowired
    private RecordsRepo repo;

    @RequestMapping
    public Collection<Record> index() {
        Collection<Record> records = new ArrayList<>();
        for (Record u : repo.findAll()) {
            records.add(u);
        }
        //return mi.values();
        return records;
        //return mi.values();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void newRecord(Record record) {
        //long id = counter.getAndIncrement();
        //record.setRecordId(id);

        repo.save(record);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putUser(Record record) {
        //mi.put(record.getRecordId(), record);
        repo.save(record);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeUser(Long id) {
        //mi.remove(id);
        repo.delete(id);
    }


}
