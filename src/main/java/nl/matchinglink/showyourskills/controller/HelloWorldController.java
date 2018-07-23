package nl.matchinglink.showyourskills.controller;

import nl.matchinglink.showyourskills.domain.HelloWorldResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HelloWorldController {

    @RequestMapping(method = GET, value = "hello")
    public HelloWorldResponse sayHello() {
        return new HelloWorldResponse("Hello World");
    }
}
