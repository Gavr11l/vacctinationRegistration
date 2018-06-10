/**
 *
 */
package ua.nure.gavr.web.abstractclasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gavr
 *
 */
public abstract class AbstractAddController<T extends AbstractVacctinationAddCommand<L>, K extends AbstractAddValidator<T,L>, L> extends AbstractViewController<T, L> {
	private static final String ACTION_ADD = "action=add";
	private static final String ACTION_BACK = "action=back";

	@Autowired
	private K validator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		webDataBinder.addValidators(validator);
	}


	@RequestMapping(method = RequestMethod.POST, params = {ACTION_BACK})
	public String handleBack(@ModelAttribute(COMMAND_NAME) AbstractVacctinationViewCommand<T> command) {
		return getListRedirect();
	}

	@RequestMapping(method = RequestMethod.POST, params = {ACTION_ADD})
	public String handleAdd(HttpSession session, @Valid @ModelAttribute(COMMAND_NAME) T command, BindingResult  bindingResult) {
		if(!bindingResult.hasErrors()) {
			processAddAction(command);
			command.setAddSuccessfull(Boolean.TRUE);
		}
		return getViewName();
	}

	protected void validateNotExistAndNoRenouncement(T command, BindingResult bindingResult) {
		validator.validateNotExistAndNoRenouncement(command, bindingResult);
	}

	protected abstract void processAddAction(T command);
}