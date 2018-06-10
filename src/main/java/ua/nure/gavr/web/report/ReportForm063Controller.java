/**
 *
 */
package ua.nure.gavr.web.report;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.nure.gavr.data.PattientVacctinationsDataWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.rtf.Form063Report;
import ua.nure.gavr.service.VacctinationService;
import ua.nure.gavr.web.SessionHelper;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping("/form063")
public class ReportForm063Controller {

	private static final String VIEW_NAME = "form063";

	@Autowired
	private MessageSource messageSource;
	@Autowired
	private VacctinationService vacctinationService;

	private void fillCommandData(ReportForm063Command command) {
		Institution institution = command.getInstitution();
		command.setPatientList(vacctinationService.findPatients(institution.getIdInstitution(), getYear(command)));
		command.setYearList(vacctinationService.findYear());
	}

	private Integer getYear(ReportForm063Command command) {
		return command.getYear();
	}

	@ModelAttribute("command")
	public ReportForm063Command createCommand(HttpSession session) {
		ReportForm063Command command = new ReportForm063Command();
		SessionHelper.fillCommand(session, command);
		return command;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String handleGet(
			@ModelAttribute("command") ReportForm063Command command)
			throws IOException {
		fillCommandData(command);
		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.GET, params = { "action=report" })
	public void handleGet(@RequestParam(value = "ptid") Integer patientId, HttpServletResponse response,
			@ModelAttribute("command") ReportForm063Command command)
			throws IOException {
		Patient patient = vacctinationService.findPatient(patientId);
		PattientVacctinationsDataWrapper dataWrapper = new PattientVacctinationsDataWrapper(
				patient, command.getInstitution())
				.setVacctinationList(vacctinationService.findVaccinations())
				.setVacctinations(vacctinationService.findVaccinationss(patientId))
				.setCalendarPlans(vacctinationService.getPatientCalendarPlans(patientId))
				.setFaults(vacctinationService.getFaults(patientId))
				.setRenouncements(vacctinationService.getRenouncements(patientId))
				.setResults(vacctinationService.getResults(patientId));

		response.setContentType("text/rtf");
		response.setHeader("Content-Disposition", "attachment;filename=rtfAtestado.rtf");

		Form063Report.instanceOf(messageSource, command.getMedEmployee(), command.getInstitution(), dataWrapper)
				.buildReport(response.getWriter());
	}

}
