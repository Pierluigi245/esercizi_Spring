package com.develhope.esercizioTre.repository;

import com.develhope.esercizioTre.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {

}
