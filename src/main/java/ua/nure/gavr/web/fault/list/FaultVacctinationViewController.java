package ua.nure.gavr.web.fault.list;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.FaultWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.rtf.PatientFaultReport;
import ua.nure.gavr.web.abstractclasses.AbstractViewController;


/**
 * @author gavr
 *
 */

@Controller
@RequestMapping(value = "/pfalrep")
public class FaultVacctinationViewController extends AbstractViewController<FaultVacctinationViewCommand, PatientCalendarPlan> {

	private static final String LIST_REDIRECT = "redirect:falrep";
	private static final String VIEW_NAME = "pfalrep";


	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected String getListRedirect() {
		return LIST_REDIRECT;
	}

	@Override
	protected PatientCalendarPlan getDomain(Integer patientId,
			Integer vacctinationId) {
		return vacctinationService.findPatientCalendarPlan(patientId, vacctinationId);
	}

	@Override
	protected FaultVacctinationViewCommand createNewCommand() {
		return new FaultVacctinationViewCommand();
	}

	@Override
	protected void fillCommandAdditionData(
			FaultVacctinationViewCommand command) {
		super.fillCommandAdditionData(command);
		command.setPatientVacctinationFault(vacctinationService.findPatientVacctinationFault(command.getPatient().getIdPatient(), command.getVacctination().getIdVacctination()));
	}

	@RequestMapping(method = RequestMethod.GET,  params = {"action=report"})
	public void handleGet(HttpServletResponse response,
			@ModelAttribute(COMMAND_NAME) FaultVacctinationViewCommand command, BindingResult bindingResult) throws IOException {
		Institution institution = command.getInstitution();
		response.setContentType("text/rtf");
		response.setHeader("Content-Disposition", "attachment;filename=rtfAtestado.rtf");

		FaultWrapper faultWrapper = new FaultWrapper();
		faultWrapper.setPatient(command.getPatient());
		faultWrapper.setPatientVacctinationFault(command.getPatientVacctinationFault());
		faultWrapper.setVacctinaionFullName(command.getVacctinationFullName());
		faultWrapper.setVacctination(command.getVacctination());

		PatientFaultReport.instanceOf(messageSource, command.getMedEmployee(), institution, faultWrapper).buildReport(response.getWriter());

	}

}
