/**
 *
 */
package ua.nure.gavr.web.fault.add;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientVacctinationFault;
import ua.nure.gavr.web.abstractclasses.AbstractAddController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping("/addvacfdata")
public class AddVacctinationFaultDataController extends AbstractAddController<AddVacctinationFaultDataCommand, AddVacctinationFaultDataValidator, PatientCalendarPlan> {

	private static final String LIST_REDIRECT = "redirect:addvacfdatalist";
	private static final String VIEW_NAME = "addvacfdata";

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected String getListRedirect() {
		return LIST_REDIRECT;
	}

	@Override
	protected PatientCalendarPlan getDomain(Integer patientId, Integer vacctinationId) {
		return vacctinationService.findPatientCalendarPlan(patientId, vacctinationId);
	}

	@Override
	protected AddVacctinationFaultDataCommand createNewCommand() {
		return new AddVacctinationFaultDataCommand();
	}

	@Override
	protected void processAddAction(AddVacctinationFaultDataCommand command) {
		PatientVacctinationFault patientVacctinationFault = new PatientVacctinationFault();
		patientVacctinationFault.setFaultReason(command.getFaultReason());
		patientVacctinationFault.setFaultTime(command.getFaultTime());
		patientVacctinationFault.setVacctinationFaultDate(command.getVacctinationDate());
		Integer patientId = command.getPatientId();
		patientVacctinationFault.setIdPatient(patientId);
		Integer vacctinationId = command.getVacctinationId();
		patientVacctinationFault.setIdVacctination(vacctinationId);

		vacctinationService.savePatientVacctinationFaultResult(patientVacctinationFault);

		int delta = 0;
		try {
			delta = Integer.parseInt(command.getFaultTime());
		} catch (Exception e) {}
		if (delta > 0) {
			PatientCalendarPlan patientCalendarPlan = vacctinationService
					.findPatientCalendarPlan(patientId, vacctinationId);
			if (patientCalendarPlan != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(patientCalendarPlan.getVacctinationDate());
				calendar.add(Calendar.MONTH, delta);
				patientCalendarPlan.setVacctinationDate(calendar.getTime());
				vacctinationService.updatePatientCalendarPlan(patientCalendarPlan);
			}
		}
	}

	@Override
	protected void procsessAdditionValidation(AddVacctinationFaultDataCommand command, BindingResult bindingResult) {
		validateNotExistAndNoRenouncement(command, bindingResult);
	}


	@Override
	protected void fillAdditionGetData(AddVacctinationFaultDataCommand command) {
		command.setVacctinationDate(new Date());
	}
}
