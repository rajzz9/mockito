package com.deepakvadgama.testing.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileService {

    @Autowired
    private ProfileSimpleRepo profileSimpleRepo;

    public Person getProfile(String name) {
        return profileSimpleRepo.getProfile(name);
    }

    public boolean createProfile(String name, int age) {
        return profileSimpleRepo.createProfile(name, age);
    }

    public boolean createProfile(Person person) {
        return profileSimpleRepo.createProfile(person);
    }
}
