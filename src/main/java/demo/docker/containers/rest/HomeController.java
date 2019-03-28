package demo.docker.containers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final Environment environment;

    @Autowired
    public HomeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/")
    public String welcome() {
        return "<h1 style='color:red;'>Welcome to spring boot docker " + " running on port " + environment.getProperty("server.port") + "\n application" +
                " name </h1>" + environment.hashCode();
    }
}
