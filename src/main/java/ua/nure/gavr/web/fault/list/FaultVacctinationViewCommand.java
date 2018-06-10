/**
 *
 */
package ua.nure.gavr.web.fault.list;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientVacctinationFault;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationViewCommand;

/**
 * @author gavr
 *
 */
public class FaultVacctinationViewCommand extends AbstractVacctinationViewCommand<PatientCalendarPlan>{
	private PatientVacctinationFault patientVacctinationFault;

	public PatientVacctinationFault getPatientVacctinationFault() {
		return patientVacctinationFault;
	}

	public void setPatientVacctinationFault(
			PatientVacctinationFault patientVacctinationFault) {
		this.patientVacctinationFault = patientVacctinationFault;
	}

}
