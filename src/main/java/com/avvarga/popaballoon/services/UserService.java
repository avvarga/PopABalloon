package com.avvarga.popaballoon.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avvarga.popaballoon.models.User;
import com.avvarga.popaballoon.repositories.RoleRepository;
import com.avvarga.popaballoon.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository uRepo;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService (UserRepository uRepo, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.uRepo = uRepo;
		this.roleRepository = roleRepository;
	}
	public User findByUsername(String login) {
    	return uRepo.findByLogin(login);
    }
	
	public void saveWithUserRole(User user) {
        user.setCode(bCryptPasswordEncoder.encode(user.getCode()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        uRepo.save(user);
    }
	public List <User> findAll(){
    	return (List<User>) uRepo.findAll();
    }
	
	
}
