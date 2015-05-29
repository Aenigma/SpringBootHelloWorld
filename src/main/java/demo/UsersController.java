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
@RequestMapping(value = "/users")
public class UsersController {

    private final Map<Long, User> mi = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    {
        final User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("test@test.org");
        user.setPhone("301-301-3011");

        newUser(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void newUser(User user) {
        long id = counter.getAndIncrement();
        user.setId(id);
        mi.put(id, user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putUser(User user) {
        long id = counter.getAndIncrement();
        user.setId(id);
        mi.put(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeUser(Long id) {
        mi.remove(id);
    }

    @RequestMapping
    public Collection<User> getUsers() {
        return mi.values();
    }

}
