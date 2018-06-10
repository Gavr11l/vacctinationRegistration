/**
 *
 */
package ua.nure.gavr.web.control.login;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.model.SystemUser;
import ua.nure.gavr.service.EmployerService;
import ua.nure.gavr.web.SessionHelper;

/**
 * @author gavr
 *
 */
@Controller
public class LoginController {
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	private EmployerService employerService;

	@InitBinder("command")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(loginValidator);
	}

	@ModelAttribute("command")
	public LoginCommand createCommand() {
		return new LoginCommand();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String handleGet(@ModelAttribute("command") LoginCommand command) {
		return "login";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public String handleGetLogout(HttpSession session) {
		SessionHelper.clearSession(session);
		return "redirect:login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login", params = {"action=login"})
	public String handleLogin(HttpSession session, @Valid @ModelAttribute("command") LoginCommand command, BindingResult  bindingResult) {
		if(!bindingResult.hasErrors()) {
			SystemUser systUser = employerService.findUser(command.getLogin(), command.getPassword());

			if (systUser != null) {
			Medemployee medEmployee = employerService.findMedEmployee(systUser.getIdSystemUser());
			List<Institution> institutionList =  employerService.findInstitution(medEmployee.getIdMedEmployee());
			SessionHelper.setInstitution(session, institutionList.get(0));
			SessionHelper.setMedemployee(session, medEmployee);
			return "redirect:mainform";
			} else {
				bindingResult.rejectValue("password", "error.invalid.password", "Invalid  password");
			}
		}
		return "login";
	}
}
