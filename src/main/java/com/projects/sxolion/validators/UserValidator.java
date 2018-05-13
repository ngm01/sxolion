package com.projects.sxolion.validators;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.projects.sxolion.models.User;
import com.projects.sxolion.services.UserService;

@Component
public class UserValidator implements Validator {
	private UserService userService;
	
	public UserValidator(UserService userService){
		this.userService = userService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		//System.out.println("Email: " + userService.findByEmail(user.getEmail()));
		if(!user.getPasswordConf().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
		if(userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Unique");
		}
	}
}
