/**
 *
 */
package ua.nure.gavr.web.renouncement.add;

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
public class AddVacctinationRenouncementDataValidator extends AbstractAddValidator<AddVacctinationRenouncementDataCommand, PatientCalendarPlan> {

	@Override
	protected Class<?> getClassType() {
		return AddVacctinationRenouncementDataCommand.class;
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
	protected void performCommonValidation(AddVacctinationRenouncementDataCommand command, Errors errors) {
		validateNotExistAndNoRenouncement(command, errors);
	}

	@Override
	protected void validateFields(
			AddVacctinationRenouncementDataCommand command, Errors errors) {
		if (!StringUtils.hasText(command.getRenouncementTime())) {
			errors.rejectValue("renouncementTime","addvacrdata.error.renouncementTime.empty",
					"renouncementTime.empty");
		}
		Date vacctinationDate = command.getVacctinationDate();
		if (vacctinationDate == null) {
			errors.rejectValue("vacctinationDate","addvacdata.error.vacctinationDate.empty",
					"vacctinationDate.empty");
		}
	}
}
