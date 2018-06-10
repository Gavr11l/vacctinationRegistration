/**
 *
 */
package ua.nure.gavr.web.abstractclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.service.VacctinationService;

/**
 * @author gavr
 *
 */
public abstract class AbstractAddValidator<T extends AbstractVacctinationAddCommand<L>, L> implements Validator {
	protected static final String PATIENT_CALENDAR_PLAN_NOT_EXIST_CODE = "addvacdata.error.patientCalendarPlan.not.exist";
	protected static final String PATIENT_CALENDAR_PLAN_NOT_EXIST = "patientCalendarPlan.not.exist";

	@Autowired
	protected VacctinationService vacctinationService;

	@Override
	public boolean supports(Class<?> clazz) {
		return getClassType().equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		@SuppressWarnings("unchecked")
		T command = (T) target;
		if(!performBasicValidation(command, errors,getDomainMsgCode(), getDomainMsg()))
			return;
		performCommonValidation(command, errors);
		validateFields(command, errors);
	}



	protected boolean performBasicValidation(T command, Errors errors, String domainMsgCode, String domainMsg) {
		Patient patient = command.getPatient();
		Vacctination vacctination = command.getVacctination();
		L domain = command.getDomain();

		if(patient == null) {
			errors.reject("addvacdata.error.patien.not.exist", "patien.not.exist");
			return false;
		}
		if(vacctination == null) {
			errors.reject("addvacdata.error.vacctination.not.exist", "vacctination.not.exist");
			return false;
		}
		if(domain == null) {
			errors.reject(domainMsgCode, domainMsg);
			return false;
		}
		return true;
	}

	public void validateNotExistAndNoRenouncement(T command, Errors bindingResult) {
		Integer idPatient = command.getPatient().getIdPatient();
		Integer idVacctination = command.getVacctination().getIdVacctination();
		PatientVacctinationRenouncement renouncement = vacctinationService
				.findPatientVacctinationRenouncement(idPatient, idVacctination);
		PatientVacctination patientVacctination = vacctinationService
				.findPatienVacctination(idPatient, idVacctination);
		if (renouncement != null) {
			bindingResult.reject("addvacdata.error.renouncement.exist",
					"renouncement.exist");
		}

		if (patientVacctination != null) {
			bindingResult.reject("addvacdata.error.patientVacctination.exist",
					"patientVacctination.exist");
		}
	}

	protected abstract Class<?> getClassType();

	protected abstract String getDomainMsg();

	protected abstract String getDomainMsgCode();

	protected abstract void validateFields(T command, Errors errors);

	protected void performCommonValidation(T command, Errors errors) { }

}
