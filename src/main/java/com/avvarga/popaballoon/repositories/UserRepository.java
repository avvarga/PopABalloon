package com.avvarga.popaballoon.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.popaballoon.models.User;

@Repository
public interface UserRepository extends CrudRepository <User,Long> {
	List <User> findAll();

	User findByLogin(String login);

}
