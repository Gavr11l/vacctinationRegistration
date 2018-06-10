/**
 *
 */
package ua.nure.gavr.web.fault.add;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.web.abstractclasses.AbstractAddValidator;

/**
 * @author gavr
 *
 */
@Component
public class AddVacctinationFaultDataValidator extends AbstractAddValidator<AddVacctinationFaultDataCommand, PatientCalendarPlan> {



	@Override
	protected Class<?> getClassType() {
		return AddVacctinationFaultDataCommand.class;
	}

	@Override
	protected String getDomainMsg() {
		return PATIENT_CALENDAR_PLAN_NOT_EXIST;
	}

	@Override
	protected String getDomainMsgCode() {
		return PATIENT_CALENDAR_PLAN_NOT_EXIST_CODE;
	}

	@Override
	protected void performCommonValidation(AddVacctinationFaultDataCommand command, Errors errors) {
		validateNotExistAndNoRenouncement(command, errors);
	}

	@Override
	protected void validateFields(AddVacctinationFaultDataCommand command, Errors errors) {
		if (!StringUtils.hasText(command.getFaultReason())) {
			errors.rejectValue("faultReason","addvacdata.error.faultReason.empty",
					"series.empty");
		}
		if (!StringUtils.hasText(command.getFaultTime())) {
			errors.rejectValue("faultTime","addvacdata.error.faultTime.empty",
					"faultTime.empty");
		}
		Date vacctinationDate = command.getVacctinationDate();
		if (vacctinationDate == null) {
			errors.rejectValue("vacctinationDate","addvacdata.error.vacctinationDate.empty",
					"vacctinationDate.empty");
		} else {
			if(vacctinationDate.before(command.getDomain().getVacctinationDate()))
				errors.rejectValue("vacctinationDate","addvacdata.error.vacctinationDate.before",
						"vacctinationDate.before");
		}
	}

}
