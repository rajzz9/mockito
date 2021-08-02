package com.deepakvadgama.testing.spring;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileSimpleRepo {

    private Map<String, Person> people = new HashMap<>();

    public Person getProfile(String name) {
        return people.get(name);
    }

    public boolean createProfile(String name, int age) {
        people.put(name, new Person(name, age));
        return true;
    }

    public boolean createProfile(Person person) {
        people.put(person.getName(), person);
        return true;
    }
}
