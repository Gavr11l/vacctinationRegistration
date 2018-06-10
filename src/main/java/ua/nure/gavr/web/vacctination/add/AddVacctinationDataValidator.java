/**
 *
 */
package ua.nure.gavr.web.vacctination.add;

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
public class AddVacctinationDataValidator extends AbstractAddValidator<AddVacctinationDataCommand, PatientCalendarPlan> {


	@Override
	protected Class<?> getClassType() {
		return AddVacctinationDataCommand.class;
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
	protected void performCommonValidation(AddVacctinationDataCommand command, Errors errors) {
		validateNotExistAndNoRenouncement(command, errors);
	}

	@Override
	protected void validateFields(AddVacctinationDataCommand command, Errors errors) {
		if (!StringUtils.hasText(command.getSeries())) {
			errors.rejectValue("series","addvacdata.error.series.empty",
					"series.empty");
		}
		if (command.getDose() == 0) {
			errors.rejectValue("dose","addvacdata.error.dose.empty",
					"dose.empty");
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
