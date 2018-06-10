/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.data;

import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.model.VacctinationFullName;

/**
 *
 * @author testtest
 */
public abstract class AbstractVacctinationWrapper {
	private Vacctination vacctination;
	private Patient patient;
	private VacctinationFullName vacctinaionFullName;

	public Vacctination getVacctination() {
		return vacctination;
	}

	public void setVacctination(Vacctination vacctination) {
		this.vacctination = vacctination;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public VacctinationFullName getVacctinaionFullName() {
		return vacctinaionFullName;
	}

	public void setVacctinaionFullName(VacctinationFullName vacctinaionFullName) {
		this.vacctinaionFullName = vacctinaionFullName;
	}

}
