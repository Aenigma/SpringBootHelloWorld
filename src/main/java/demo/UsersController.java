package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @Autowired
    private UserRepo repo;

    public UsersController() {
        final User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("test@test.org");
        user.setPhone("301-301-3011");
        // can't do this; repo hasn't been injected yet...
        // newUser(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void newUser(User user) {
        repo.save(user);
        /*
        long id = counter.getAndIncrement();
        user.setId(id);
        mi.put(id, user);
        */
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putUser(User user) {
        repo.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeUser(Long id) {
        //mi.remove(id);
        repo.delete(id);
    }

    @RequestMapping
    public Collection<User> getUsers() {
        Collection<User> users = new ArrayList<>();
        for(User u : repo.findAll()) {
            users.add(u);
        }
        //return mi.values();
        return users;
    }

}
