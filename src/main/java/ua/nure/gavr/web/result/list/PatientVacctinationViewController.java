/**
 *
 */
package ua.nure.gavr.web.result.list;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.VacctinationWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.rtf.VacctinationReport;
import ua.nure.gavr.web.abstractclasses.AbstractViewController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping(value = "/pvacrep")
public class PatientVacctinationViewController extends AbstractViewController<PatientVacctinationViewCommand, PatientVacctination>{

	private static final String LIST_REDIRECT = "redirect:vacrep";
	private static final String VIEW_NAME = "pvacrep";

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected String getListRedirect() {
		return LIST_REDIRECT;
	}

	@Override
	protected PatientVacctination getDomain(Integer patientId, Integer vacctinationId) {
		return vacctinationService.findPatienVacctination(patientId, vacctinationId);
	}


	@Override
	protected PatientVacctinationViewCommand createNewCommand() {
		return new PatientVacctinationViewCommand();
	}

	@Override
	protected void fillCommandAdditionData(
			PatientVacctinationViewCommand command) {
		super.fillCommandAdditionData(command);
		command.setVacctinationResult(vacctinationService.findPatientVacctinationResult(command.getDomain().getIdPatientVacctination()));
	}

	@RequestMapping(method = RequestMethod.GET,  params = {"action=report"})
	public void handleGet(HttpServletResponse response,
			@ModelAttribute(COMMAND_NAME) PatientVacctinationViewCommand command, BindingResult bindingResult) throws IOException {
		Institution institution = command.getInstitution();
		response.setContentType("text/rtf");
		response.setHeader("Content-Disposition", "attachment;filename=rtfAtestado.rtf");

		VacctinationWrapper vacctinationWrapper = new VacctinationWrapper();
		vacctinationWrapper.setPatient(command.getPatient());
		vacctinationWrapper.setPatientVacctinaion(command.getDomain());
		vacctinationWrapper.setPatientVacctinationResult(command.getVacctinationResult());
		vacctinationWrapper.setVacctinaionFullName(command.getVacctinationFullName());
		vacctinationWrapper.setVacctination(command.getVacctination());

		VacctinationReport.instanceOf(messageSource, command.getMedEmployee(), institution, vacctinationWrapper)
				.buildReport(response.getWriter());
	}


}
