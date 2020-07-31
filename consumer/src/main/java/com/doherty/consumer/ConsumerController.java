package com.doherty.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/person/{personId}")
    String getPerson(@PathVariable("personId") Long personId) {
        Person person = this.restTemplate.getForObject("http://localhost:8000/person/{personId}", Person.class, personId);
        return "PERSON: " + person.getName();
    }

}
