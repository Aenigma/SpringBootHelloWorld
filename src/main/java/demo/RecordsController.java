package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Kevin
 */
@RestController
@RequestMapping(value = "/records")
public class RecordsController {

    private final Map<Long, Record> mi = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping
    public Collection<Record> index() {
        return mi.values();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void newRecord(Record record) {
        long id = counter.getAndIncrement();
        record.setRecordId(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putUser(Record record) {
        mi.put(record.getRecordId(), record);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeUser(Long id) {
        mi.remove(id);
    }


}
