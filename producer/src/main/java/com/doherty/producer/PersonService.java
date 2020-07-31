package com.doherty.producer;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {

    private final Map<Long, Person> personMap;

    public PersonService() {
        personMap = new HashMap<>();
        personMap.put(1L, new Person(1L, "Michael", "Jordan"));
        personMap.put(2L, new Person(2L, "Scottie", "Pippen"));
        personMap.put(3L, new Person(3L, "Dennis", "Rodman"));
    }

    Person findPersonById(Long id) {
        return personMap.get(id);
    }

}
