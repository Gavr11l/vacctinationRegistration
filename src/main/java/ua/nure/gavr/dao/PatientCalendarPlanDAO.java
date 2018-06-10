/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientCalendarPlan;

/**
 * @author gavr
 *
 */
public interface PatientCalendarPlanDAO {
	public PatientCalendarPlan findPatientCalendarPlan(Integer patientCalendarPlanId);

	public List<PatientCalendarPlan> findPlannedVacctinationsCP(
			Integer idInstitution, List<Integer> vacctinationIds, Integer year);

	public void updatePatientCalendarPlan(PatientCalendarPlan patientCalendarPlan);

	public void savePatientCalendarPlan(PatientCalendarPlan patientCalendarPlan);

	public PatientCalendarPlan findPatientCalendarPlan(Integer patientId, Integer vacctinationId);

	public List<PatientCalendarPlan> findPlannedVacctinationsWithoutFaultAndRenouncement(
			Integer institutionId, DateType dateType, List<Integer> vactinationIds);

	public List<PatientCalendarPlan> findPlannedVacctinations(Integer institutionId,
			DateType dateType, List<Integer> vacctinationIds);

	public List<PatientCalendarPlan> findPatientCalendarPlans(Integer patientId);

}
