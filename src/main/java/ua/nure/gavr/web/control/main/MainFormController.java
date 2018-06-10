/**
 * 
 */
package ua.nure.gavr.web.control.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.web.SessionHelper;

/**
 * @author gavr
 *
 */
@Controller
public class MainFormController {
	
	@ModelAttribute("command")
	public MainFormCommand createCommand(HttpSession session) {
		MainFormCommand command = new MainFormCommand();
		SessionHelper.fillCommand(session, command);
		return command;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mainform")
	public String handleGet(@ModelAttribute("command") MainFormCommand command) {
		return "mainform";
	}
	
	

}
