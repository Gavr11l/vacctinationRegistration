/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.service;

import java.util.List;

import ua.nure.gavr.data.CalendarPlanWrapper;
import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.FaultWrapper;
import ua.nure.gavr.data.RenouncementWrapper;
import ua.nure.gavr.data.VacctinationWrapper;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationFault;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.model.PatientVacctinationResult;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.model.VacctinationFullName;

/**
 *
 * @author gavr
 */
public interface VacctinationService {

	List<FaultWrapper> findFaultVacctination(Integer idInstitution,
			DateType dateType, List<Integer> idsVactination);

	List<CalendarPlanWrapper> findPlannedVacctinations(Integer idInstitution,
			DateType dateType, List<Integer> idsVactination);

	List<CalendarPlanWrapper> findPlannedVacctinationsWithoutFaultAndRenouncement(
			Integer idInstitution, DateType dateType,
			List<Integer> idsVactination);

	List<RenouncementWrapper> findRecouncementVacctination(
			Integer idInstitution, DateType dateType,
			List<Integer> idsVactination);

	List<Vacctination> findVaccinations();

	List<VacctinationWrapper> findVacctination(Integer idInstitution,
			DateType dateType, List<Integer> idsVactination);

	void savePatientVacctinationData(PatientVacctination patientVacctination);

	void savePatientVacctinationFaultResult(
			PatientVacctinationFault patientVacctinationFault);

	void savePatientVacctinationRenouncement(
			PatientVacctinationRenouncement renouncement);

	void savePatientVacctinationResult(
			PatientVacctinationResult patientVacctinationResult);

	void updatePatientVacctinationResult(
			PatientVacctinationResult patientVacctinationResult);

	public PatientVacctination findPatienVacctination(Integer idPatient,
			Integer idVacctination);

	public void updatePatienVacctination(PatientVacctination patientVacctination);

	public PatientCalendarPlan findPatientCalendarPlan(Integer idPatient,
			Integer idVacctination);

	public List<Patient> findPatients(Integer idInstitution);

	public void updatePatientCalendarPlan(
			PatientCalendarPlan existPatientCalendarPlan);

	public void savePatientCalendarPlan(PatientCalendarPlan calendarPlan);

	public Patient findPatient(Integer patientId);

	public Vacctination findVacctination(Integer vacctinationId);

	public VacctinationFullName findVacctinationFullName(Integer vacctinationId);

	public PatientVacctinationRenouncement findPatientVacctinationRenouncement(
			Integer patientId, Integer vacctinationId);

	public List<PatientParent> findPatientParents(Integer patientId);

	public List<Integer> findYear();

	public List<CalendarPlanWrapper> findPlannedVacctinationsCP(Integer idInstitution,
			List<Integer> vacctinationIds, Integer year);

	public List<Patient> findPatients(Integer idInstitution, Integer year);

	public PatientCalendarPlan findPatientCalendarPlan(Integer patientCalendarPlanId);

	public PatientVacctinationResult findPatientVacctinationResult(Integer patientVacctinationId);

	public PatientVacctinationFault findPatientVacctinationFault(Integer patientId, Integer vacctinationId);

	public List<PatientCalendarPlan> getPatientCalendarPlans(Integer patientId);

	public List<PatientVacctinationFault> getFaults(Integer patientId);

	public List<PatientVacctinationRenouncement> getRenouncements(Integer patientId);

	public List<PatientVacctinationResult> getResults(Integer patientId);

	public List<PatientVacctination> findVaccinationss(Integer patientId);

	public PatientParent findPatientParent(Integer patientParentId);

}
