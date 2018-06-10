/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.data;

import ua.nure.gavr.model.PatientVacctinationFault;

/**
 *
 * @author testtest
 */
public class FaultWrapper extends AbstractVacctinationWrapper {
	private PatientVacctinationFault patientVacctinationFault;

	public PatientVacctinationFault getPatientVacctinationFault() {
		return patientVacctinationFault;
	}

	public void setPatientVacctinationFault(
			PatientVacctinationFault patientVacctinationFault) {
		this.patientVacctinationFault = patientVacctinationFault;
	}

}
