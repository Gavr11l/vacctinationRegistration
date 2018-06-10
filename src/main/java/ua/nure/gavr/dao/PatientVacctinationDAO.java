/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientVacctination;

/**
 * @author gavr
 *
 */
public interface PatientVacctinationDAO {

	public PatientVacctination findPatientVaccination(Integer patientId, Integer vacctinationId);

	public void savePatientVacctinationData(PatientVacctination patientVacctination);

	public void updatePatienVacctination(PatientVacctination patientVacctination);

	public List<PatientVacctination> findVacctination(Integer institutionId,
			DateType dateType, List<Integer> vacctinationIds);

	public List<PatientVacctination> findVaccinationss(Integer patientId);


}
