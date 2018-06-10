/**
 *
 */
package ua.nure.gavr.web.renouncement.list;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationViewCommand;

/**
 * @author gavr
 *
 */
public class RenouncementVacctinationViewCommand extends AbstractVacctinationViewCommand<PatientCalendarPlan>{
	private PatientVacctinationRenouncement patientVacctinationRenouncement;
	private PatientParent patientParent;

	public PatientVacctinationRenouncement getPatientVacctinationRenouncement() {
		return patientVacctinationRenouncement;
	}

	public void setPatientVacctinationRenouncement(
			PatientVacctinationRenouncement patientVacctinationRenouncement) {
		this.patientVacctinationRenouncement = patientVacctinationRenouncement;
	}

	public PatientParent getPatientParent() {
		return patientParent;
	}

	public void setPatientParent(PatientParent patientParent) {
		this.patientParent = patientParent;
	}

}
