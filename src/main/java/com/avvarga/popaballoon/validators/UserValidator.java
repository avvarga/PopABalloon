package com.avvarga.popaballoon.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.avvarga.popaballoon.models.User;
import com.avvarga.popaballoon.repositories.UserRepository;


@Component
public class UserValidator implements Validator{

	private final UserRepository userRepo;
	public UserValidator (UserRepository userRepo) {
		this.userRepo = userRepo;
	}
    //    1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
       
        User user2 = userRepo.findByLogin(user.getLogin());
        if (user2 != null) {
        	errors.rejectValue("login", "Unique");
        }
    }
}
