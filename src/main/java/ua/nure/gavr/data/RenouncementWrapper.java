/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.data	;

import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.model.PatientVacctinationRenouncement;

/**
 *
 * @author testtest
 */
public class RenouncementWrapper extends AbstractVacctinationWrapper {

	private PatientVacctinationRenouncement patientVacctinationRenouncement;
	private PatientParent patientParent;

	public PatientParent getPatientParent() {
		return patientParent;
	}

	public void setPatientParent(PatientParent patientParent) {
		this.patientParent = patientParent;
	}

	public PatientVacctinationRenouncement getPatientVacctinationRenouncement() {
		return patientVacctinationRenouncement;
	}

	public void setPatientVacctinationRenouncement(
			PatientVacctinationRenouncement patientVacctinationRenouncement) {
		this.patientVacctinationRenouncement = patientVacctinationRenouncement;
	}

}
