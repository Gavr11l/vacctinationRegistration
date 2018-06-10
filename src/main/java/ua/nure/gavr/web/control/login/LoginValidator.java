/**
 *
 */
package ua.nure.gavr.web.control.login;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author gavr
 *
 */
@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors error) {
		LoginCommand command = (LoginCommand) arg0;
		if (!StringUtils.hasText(command.getLogin())) {
			error.rejectValue("login", "error.empty.login","Empty login!");
		}
		if (!StringUtils.hasText(command.getPassword())) {
			error.rejectValue("password", "error.empty.password","Empty password!");
		}

	}

}
