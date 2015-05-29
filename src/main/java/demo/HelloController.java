package demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @RequestMapping
    public String index() {
        return "Hello world!";
    }

}
