package com.deepakvadgama.testing.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileDbService {

    @Autowired
    private ProfileRepository profileRepository;

    public Person getProfile(String name) {
        return profileRepository.findOne(name);
    }

    public boolean createProfile(String name, int age) {
        Person savedPerson = profileRepository.save(new Person(name, age));
        return savedPerson != null;
    }

    public boolean createProfile(Person person) {
        Person savedPerson = profileRepository.save(person);
        return savedPerson != null;
    }
}
