package com.deepakvadgama.testing.springdb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileSimpleRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void testDbProfileInsertion() throws Exception {
        profileRepository.save(new Person("John Wick", 35));

        Person person = profileRepository.findOne("John Wick");

        assertThat(person).isNotNull();
        assertThat(person.getName()).isNotBlank();
        assertThat(person.getName()).isEqualTo("John Wick");
        assertThat(person.getAge()).isEqualTo(35);
    }
}