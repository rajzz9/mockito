package com.deepakvadgama.testing.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProfileService.class, ProfileSimpleRepo.class})
public class ProfileServiceTest {

    @MockBean
    private ProfileSimpleRepo profileSimpleRepo;

    @Autowired
    private ProfileService profileService;

    @Test
    public void getProfile() throws Exception {
        when(profileSimpleRepo.getProfile("John Wick")).thenReturn(new Person("John Wick", 35));

        Person person = profileService.getProfile("John Wick");

        assertThat(person).isNotNull();
        assertThat(person.getName()).isNotBlank();
        assertThat(person.getName()).isEqualTo("John Wick");
        assertThat(person.getAge()).isEqualTo(35);
    }

}