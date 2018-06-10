/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.model.PatientVacctinationResult;

/**
 * @author gavr
 *
 */
public interface PatientVacctinationResultDAO {

	public void savePatientVacctinationResult(PatientVacctinationResult patientVacctinationResult);

	public void updatePatientVacctinationResult(PatientVacctinationResult patientVacctinationResult);

	public PatientVacctinationResult findPatientVacctinationResult(Integer paatientVacctinationId);

	public List<PatientVacctinationResult> findResults(Integer patientId);
}
