package ratz.pereira.com;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greetings greetings(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }
}
