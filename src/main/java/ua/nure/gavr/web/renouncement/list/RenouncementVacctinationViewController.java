/**
 *
 */
package ua.nure.gavr.web.renouncement.list;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.RenouncementWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.rtf.PatientRenouncementReport;
import ua.nure.gavr.web.abstractclasses.AbstractViewController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping(value = "/prenrep")
public class RenouncementVacctinationViewController extends AbstractViewController<RenouncementVacctinationViewCommand, PatientCalendarPlan>{

	private static final String LIST_REDIRECT = "redirect:renrep";
	private static final String VIEW_NAME = "prenrep";


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
	protected RenouncementVacctinationViewCommand createNewCommand() {
		return new RenouncementVacctinationViewCommand();
	}

	@Override
	protected void fillCommandAdditionData(
			RenouncementVacctinationViewCommand command) {
		super.fillCommandAdditionData(command);
		PatientVacctinationRenouncement patientVacctinationRenouncement = vacctinationService.findPatientVacctinationRenouncement(
				command.getPatient().getIdPatient(), command.getVacctination().getIdVacctination());
		command.setPatientVacctinationRenouncement(patientVacctinationRenouncement);
		if(patientVacctinationRenouncement != null)
			command.setPatientParent(vacctinationService.findPatientParent(patientVacctinationRenouncement.getIdPatientParent()));
	}

	@RequestMapping(method = RequestMethod.GET,  params = {"action=report"})
	public void handleGet(HttpServletResponse response,
			@ModelAttribute(COMMAND_NAME) RenouncementVacctinationViewCommand command, BindingResult bindingResult) throws IOException {
		Institution institution = command.getInstitution();
		response.setContentType("text/rtf");
		response.setHeader("Content-Disposition", "attachment;filename=rtfAtestado.rtf");

		RenouncementWrapper renouncementWrapper =  new RenouncementWrapper();

		renouncementWrapper.setPatient(command.getPatient());
		renouncementWrapper.setPatientVacctinationRenouncement(command.getPatientVacctinationRenouncement());
		renouncementWrapper.setVacctinaionFullName(command.getVacctinationFullName());
		renouncementWrapper.setPatientParent(command.getPatientParent());
		renouncementWrapper.setVacctination(command.getVacctination());

		PatientRenouncementReport.instanceOf(messageSource, command.getMedEmployee(), institution, renouncementWrapper).buildReport(response.getWriter());

	}

}
