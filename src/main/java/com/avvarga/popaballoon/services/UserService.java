package com.avvarga.popaballoon.services;

import org.springframework.stereotype.Service;

import com.avvarga.popaballoon.models.User;
import com.avvarga.popaballoon.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository uRepo;
	public UserService (UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	public void saveUser(User user) {
		uRepo.save(user);
	}

}
