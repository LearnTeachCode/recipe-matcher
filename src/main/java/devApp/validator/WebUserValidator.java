package devApp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import devApp.entity.user.model.WebUser;
import devApp.entity.user.service.WebUserService;

@Component
public class WebUserValidator implements Validator{

	@Autowired
	private WebUserService webUserService;

	@Override
	public boolean supports(Class<?> arg0) {		
		return WebUser.class.equals(arg0);
	}

	/*
	 * @param gets WebUser from userForm
	 * Validates User registration against wrong or incorrect credentials 
	 */
	@Override
	public void validate(Object arg0, Errors arg1) {
		WebUser webUser = (WebUser) arg0;
		
		// UserName : required
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "username", "Required", "The field is required");
		
		// UserName : size <8 or >12
		if(webUser.getUsername().length() < 8 || webUser.getUsername().length() > 32){
			arg1.rejectValue("username", "UsernameSize", "The field is out of size");
		}
		
		// UserName : already exists in the system
		if(this.webUserService.findByUsername(webUser.getUsername())!=null){
			arg1.rejectValue("username", "Duplicate", "A user with username already exists");
		}
		
		// Password : required
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "Required", "The field is required");
		
		// Password : size <7 or >32
		if(webUser.getPassword().length() < 7 || webUser.getPassword().length() > 32){
			arg1.rejectValue("password", "PasswordSize", "The field is out of size");
		}
		
		// ConfirmPassword : passwords are not matching
		if(!webUser.getConfirmPassword().equals(webUser.getPassword())){
			arg1.rejectValue("confirmPassword", "Different", "Password values are different");
		}
		
	}

}
