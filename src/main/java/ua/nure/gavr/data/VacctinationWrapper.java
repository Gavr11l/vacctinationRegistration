/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.data;

import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationResult;

/**
 *
 * @author testtest
 */
public class VacctinationWrapper extends AbstractVacctinationWrapper {

	private PatientVacctination patientVacctinaion;
	private PatientVacctinationResult patientVacctinationResult;

	public PatientVacctinationResult getPatientVacctinationResult() {
		return patientVacctinationResult;
	}

	public void setPatientVacctinationResult(
			PatientVacctinationResult patientVacctinationResult) {
		this.patientVacctinationResult = patientVacctinationResult;
	}

	public PatientVacctination getPatientVacctinaion() {
		return patientVacctinaion;
	}

	public void setPatientVacctinaion(PatientVacctination patientVacctinaion) {
		this.patientVacctinaion = patientVacctinaion;
	}

}
