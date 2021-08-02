package com.deepakvadgama.testing.springdb;

import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Person, String> {

}
