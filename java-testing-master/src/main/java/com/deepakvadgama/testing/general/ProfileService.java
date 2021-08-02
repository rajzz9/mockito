package com.deepakvadgama.testing.general;

public class ProfileService {

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Person getProfile(String name) {
        return profileRepository.getProfile(name);
    }

    public boolean createProfile(String name, int age) {
        return profileRepository.createProfile(name, age);
    }

    public boolean createProfile(Person person) {
        return profileRepository.createProfile(person);
    }
}
