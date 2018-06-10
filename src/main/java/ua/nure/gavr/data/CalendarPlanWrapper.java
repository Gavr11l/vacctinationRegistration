/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.data;

import java.util.List;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientParent;

/**
 *
 * @author testtest
 */
public class CalendarPlanWrapper extends AbstractVacctinationWrapper {

	private PatientCalendarPlan patientCalendarPlan;
	private List<PatientParent> patientParentList;

	public List<PatientParent> getPatientParentList() {
		return patientParentList;
	}

	public void setPatientParentList(List<PatientParent> patientParentList) {
		this.patientParentList = patientParentList;
	}

	public PatientCalendarPlan getPatientCalendarPlan() {
		return patientCalendarPlan;
	}

	public void setPatientCalendarPlan(PatientCalendarPlan patientCalendarPlan) {
		this.patientCalendarPlan = patientCalendarPlan;
	}

}
