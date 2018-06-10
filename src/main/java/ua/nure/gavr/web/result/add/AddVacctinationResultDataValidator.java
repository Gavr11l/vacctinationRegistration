/**
 *
 */
package ua.nure.gavr.web.result.add;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.web.abstractclasses.AbstractAddValidator;

/**
 * @author gavr
 *
 */
@Component
public class AddVacctinationResultDataValidator extends AbstractAddValidator<AddVacctinationResultDataCommand, PatientVacctination> {

	private static final String PATIENT_VACTINATION_NOT_EXIST_CODE = "addvacdata.error.patientVactination.not.exist";
	private static final String PATIENT_VACTINATION_NOT_EXIST = "patientVactination.not.exist";

	@Override
	protected Class<?> getClassType() {
		return AddVacctinationResultDataCommand.class;
	}

	@Override
	protected String getDomainMsg() {
		return PATIENT_VACTINATION_NOT_EXIST;
	}

	@Override
	protected String getDomainMsgCode() {
		return PATIENT_VACTINATION_NOT_EXIST_CODE;
	}

	@Override
	protected void validateFields(AddVacctinationResultDataCommand command, Errors errors) {
		if (!StringUtils.hasText(command.getReactionGlobal())) {
			errors.rejectValue("reactionGlobal","addvacresdata.error.reactionGlobal.empty",
					"reactionGlobal.empty");
		}
		if (!StringUtils.hasText(command.getReactionLocal())) {
			errors.rejectValue("reactionLocal","addvacresdata.error.reactionLocal.empty",
					"reactionLocal.empty");
		}
		if (!StringUtils.hasText(command.getResult())) {
			errors.rejectValue("result","addvacresdata.error.result.empty",
					"result.empty");
		}

	}
}
