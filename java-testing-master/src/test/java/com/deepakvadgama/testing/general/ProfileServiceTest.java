package com.deepakvadgama.testing.general;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest {

    private ProfileService profileService;

    @Mock
    private ProfileRepository profileRepository;

    @Before
    public void setUp() throws Exception {
        profileService = new ProfileService(profileRepository);
    }

    @Test
    public void getProfile() throws Exception {
        Mockito.when(profileRepository.getProfile("John Wick"))
                .thenReturn(new Person("John Wick", 35));

        Person person = profileService.getProfile("John Wick");

        assertThat(person).isNotNull();
        assertThat(person.getName()).startsWith("John").endsWith("Wick");
    }

    @Test
    public void getProfileForMultiplePeople() throws Exception {
        Mockito.when(profileRepository.getProfile("John Wick"))
                .thenReturn(null)
                .thenReturn(new Person("John Wick", 35));

        Person firstTime = profileService.getProfile("John Wick");
        Person secondTime = profileService.getProfile("John Wick");

        assertThat(firstTime).isNull();
        assertThat(secondTime).isNotNull();
        assertThat(secondTime.getName()).startsWith("John").endsWith("Wick");
    }

    @Test
    public void verifyRepositoryBeingCalled() throws Exception {
        Mockito.when(profileRepository.getProfile("John Wick"))
                .thenReturn(new Person("John Wick", 35));

        Person person = profileService.getProfile("John Wick");

        Mockito.verify(profileRepository).getProfile("John Wick");
        Mockito.verify(profileRepository).getProfile(Matchers.anyString());
        Mockito.verify(profileRepository, Mockito.times(1)).getProfile(Matchers.anyString());
    }

    @Test
    public void verifyCreateProfile() throws Exception {
        Mockito.when(profileRepository.createProfile("John Wick", 35))
                .thenReturn(true);

        boolean result = profileService.createProfile("John Wick", 35);

        Assertions.assertThat(result).isTrue();

        Mockito.verify(profileRepository).createProfile("John Wick", 35);
        Mockito.verify(profileRepository).createProfile(Matchers.anyString(), Matchers.anyInt());
        // Will fail, can't mix matchers with raw values
//        Mockito.verify(profileRepository).createProfile(Matchers.anyString(), 35);
    }

    @Test
    public void verifyCreateProfileWithClass() throws Exception {
        Mockito.when(profileRepository.createProfile(Matchers.any(Person.class)))
                .thenReturn(true);

        Person person = new Person("John Wick", 35);
        boolean result = profileService.createProfile(person);

        Assertions.assertThat(result).isTrue();

        Mockito.verify(profileRepository).createProfile(person);
        Mockito.verify(profileRepository).createProfile(Matchers.any(Person.class));
    }

    @Test(expected = RuntimeException.class)
    public void createProfile1() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(profileRepository.getProfile("John Wick"));
        profileService.getProfile("John Wick");
    }
}