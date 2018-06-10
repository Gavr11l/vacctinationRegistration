/**
 *
 */
package ua.nure.gavr.web.result.add;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationResult;
import ua.nure.gavr.web.abstractclasses.AbstractAddController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping("/addvacresdata")
public class AddVacctinationResultDataController extends AbstractAddController<AddVacctinationResultDataCommand, AddVacctinationResultDataValidator, PatientVacctination>{

	private static final String LIST_REDIRECT = "redirect:addvacresdatalist";
	private static final String VIEW_NAME = "addvacresdata";

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
	protected AddVacctinationResultDataCommand createNewCommand() {
		return new AddVacctinationResultDataCommand();
	}

	@Override
	protected void processAddAction(AddVacctinationResultDataCommand command) {
		PatientVacctinationResult patientVacctinationResult = new PatientVacctinationResult();
		patientVacctinationResult.setResult(command.getResult());
		patientVacctinationResult.setGlobalReaction(command.getReactionLocal());
		patientVacctinationResult.setLocalReaction(command.getReactionGlobal());
		patientVacctinationResult.setIdPatientVacctination(command.getDomain().getIdPatientVacctination());
		vacctinationService.savePatientVacctinationResult(patientVacctinationResult);
	}
}