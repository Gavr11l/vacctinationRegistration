/**
 *
 */
package ua.nure.gavr.web.abstractclasses;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.model.VacctinationFullName;
import ua.nure.gavr.service.VacctinationService;
import ua.nure.gavr.web.SessionHelper;

/**
 * @author gavr
 *
 */
public abstract class AbstractViewController<T extends AbstractVacctinationViewCommand<L>, L> {
	protected static final String COMMAND_NAME = "command";


	@Autowired
	protected VacctinationService vacctinationService;
	@Autowired
	protected MessageSource messageSource;

	@ModelAttribute(COMMAND_NAME)
	public T createCommand(HttpSession session,
			@RequestParam(value = "ptid", required = true) Integer patientId,
			@RequestParam(value = "vcid", required = true) Integer vacctinationId) {
		T command = createNewCommand();
		SessionHelper.fillCommand(session, command);
		command.setPatientId(patientId);
		command.setVacctinationId(vacctinationId);

		if (patientId != null && vacctinationId != null) {
			Patient patient = vacctinationService.findPatient(patientId);
			Vacctination vacctination = vacctinationService.findVacctination(vacctinationId);
			VacctinationFullName vacctinationFullName = vacctinationService.findVacctinationFullName(vacctinationId);
			L domain = getDomain(patientId, vacctinationId);
			command.setPatient(patient);
			command.setDomain(domain);
			command.setVacctination(vacctination);
			command.setVacctinationFullName(vacctinationFullName);
			fillCommandAdditionData(command);
		}
		return command;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String handleGet(@ModelAttribute(COMMAND_NAME) T command, BindingResult bindingResult) {
		Patient patient = command.getPatient();
		Vacctination vacctination = command.getVacctination();

		L domain = command.getDomain();
		if (patient == null || vacctination == null || domain == null)
			return getListRedirect();

		procsessAdditionValidation(command, bindingResult);
		fillAdditionGetData(command);
		return getViewName();
	}

	protected abstract String getViewName();

	protected abstract String getListRedirect();

	protected abstract L getDomain(Integer patientId, Integer vacctinationId);

	protected abstract T createNewCommand();

	protected void procsessAdditionValidation(T command, BindingResult bindingResult) { }

	protected void fillCommandAdditionData(T command) { }

	protected void fillAdditionGetData(T command) { }



}
