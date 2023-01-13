package ro.qatools.banking.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import ro.qatools.banking.dto.Info;
import ro.qatools.banking.dto.Person;

import java.util.List;
import java.util.stream.Stream;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HelloController {
    @RequestMapping(method = GET, path = "/hello/{name}")
    //@GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "Hello " + name + "!";
    }

    @PostMapping(path = "/bye")
    public String goodbye(@RequestBody Info info) {
        return "Goodbye " + info.getName();
    }

    @PostMapping(path = "/echo")
    public <T> T echo(@RequestBody T obj) {
        return obj;
    }

    @GetMapping(path = "/all")
    public Stream<Person> all() {
        return Stream.of("Maria", "Tania", "Adela").map(Person::new);
    }

    @GetMapping(path = "/status")
    public Info status(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.setHeader("x", "demo");
        return new Info("demo");
    }
}
