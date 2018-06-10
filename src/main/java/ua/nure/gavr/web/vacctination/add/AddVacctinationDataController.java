/**
 *
 */
package ua.nure.gavr.web.vacctination.add;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.web.abstractclasses.AbstractAddController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping("/addvacdata")
public class AddVacctinationDataController extends AbstractAddController<AddVacctinationDataCommand, AddVacctinationDataValidator, PatientCalendarPlan>{
	private static final String LIST_REDIRECT = "redirect:addvacdatalist";
	private static final String VIEW_NAME = "addvacdata";

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
	protected AddVacctinationDataCommand createNewCommand() {
		return new AddVacctinationDataCommand();
	}

	@Override
	protected void processAddAction(AddVacctinationDataCommand command) {
		PatientVacctination patientVacctination = new PatientVacctination();
		patientVacctination.setDose(command.getDose());
		patientVacctination.setVacctinationDate(command.getVacctinationDate());
		patientVacctination.setSeries(command.getSeries());
		patientVacctination.setIdPatient(command.getPatientId());
		patientVacctination.setIdVacctination(command.getVacctinationId());
		vacctinationService.savePatientVacctinationData(patientVacctination);
	}

	@Override
	protected void fillAdditionGetData(AddVacctinationDataCommand command) {
		command.setVacctinationDate(new Date());
	}

	@Override
	protected void procsessAdditionValidation(
			AddVacctinationDataCommand command, BindingResult bindingResult) {
		validateNotExistAndNoRenouncement(command, bindingResult);
	}
}