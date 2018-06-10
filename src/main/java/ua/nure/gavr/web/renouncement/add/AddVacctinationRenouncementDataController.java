/**
 *
 */
package ua.nure.gavr.web.renouncement.add;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.web.abstractclasses.AbstractAddController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping("/addvacrdata")
public class AddVacctinationRenouncementDataController extends AbstractAddController<AddVacctinationRenouncementDataCommand, AddVacctinationRenouncementDataValidator, PatientCalendarPlan>{
	private static final String LIST_REDIRECT = "redirect:addvacrdatalist";
	private static final String VIEW_NAME = "addvacrdata";

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
	protected AddVacctinationRenouncementDataCommand createNewCommand() {
		return new AddVacctinationRenouncementDataCommand();
	}

	@Override
	protected void fillCommandAdditionData(AddVacctinationRenouncementDataCommand command) {
		List<PatientParent> patientParentList = vacctinationService.findPatientParents(command.getPatientId());
		command.setPatientParentList(patientParentList);
	}

	@Override
	protected void processAddAction(AddVacctinationRenouncementDataCommand command) {
		PatientVacctinationRenouncement patientVacctinationRenouncement = new PatientVacctinationRenouncement();
		patientVacctinationRenouncement.setRenouncementTime(command.getRenouncementTime());
		patientVacctinationRenouncement.setRenouncementDate(command.getVacctinationDate());
		patientVacctinationRenouncement.setIdPatientParent(command.getPatientParentId());

		patientVacctinationRenouncement.setIdPatient(command.getPatientId());
		patientVacctinationRenouncement.setIdVacctination(command.getVacctinationId());
		vacctinationService.savePatientVacctinationRenouncement(patientVacctinationRenouncement);
	}


	@Override
	protected void fillAdditionGetData(AddVacctinationRenouncementDataCommand command) {
		command.setVacctinationDate(new Date());
	}

	@Override
	protected void procsessAdditionValidation(AddVacctinationRenouncementDataCommand command, BindingResult bindingResult) {
		validateNotExistAndNoRenouncement(command, bindingResult);
	}
}