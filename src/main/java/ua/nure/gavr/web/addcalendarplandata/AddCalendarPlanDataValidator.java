/**
 *
 */
package ua.nure.gavr.web.addcalendarplandata;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.service.VacctinationService;

/**
 * @author gavr
 *
 */
@Component
public class AddCalendarPlanDataValidator implements Validator{
	@Autowired
	private VacctinationService vacctinationService;

	@Override
	public boolean supports(Class<?> clazz) {
		return AddCalendarPlanDataCommand.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddCalendarPlanDataCommand command = (AddCalendarPlanDataCommand) target;
		Integer patientId = command.getPatientId();
		Integer vacctinationId = command.getVacctinationId();
		Patient patient = vacctinationService.findPatient(patientId);
		Vacctination vacctination = vacctinationService.findVacctination(vacctinationId);

		if(patient == null) {
			errors.reject("addvacdata.error.patien.not.exist", "patien.not.exist");
			return;
		}
		if(vacctination == null) {
			errors.reject("addvacdata.error.vacctination.not.exist", "vacctination.not.exist");
			return;
		}

		if(command.getPatientList() == null) {
			PatientCalendarPlan patientCalendarPlan = vacctinationService.findPatientCalendarPlan(patientId, vacctinationId);

			if (patientCalendarPlan != null) {
				errors.reject("addcpdata.error.patientcp.exist",
						"patientcp.exist");
			}

			PatientVacctinationRenouncement renouncement = vacctinationService
					.findPatientVacctinationRenouncement(patientId,
							vacctinationId);
			PatientVacctination patientVacctination = vacctinationService
					.findPatienVacctination(patientId,
							vacctinationId);

			if (renouncement != null) {
				errors.reject("addcpdata.error.renouncement.exist",
						"renouncement.exist");
			}
			if (patientVacctination != null) {
				errors.reject("addcpdata.error.patientVacctination.exist",
						"patientVacctination.exist");
			}
		}
		Date vacctinationDate = command.getVacctinationDate();
		if (vacctinationDate == null) {
			errors.rejectValue("vacctinationDate","addvacdata.error.vacctinationDate.empty",
					"vacctinationDate.empty");
		}

	}
}
