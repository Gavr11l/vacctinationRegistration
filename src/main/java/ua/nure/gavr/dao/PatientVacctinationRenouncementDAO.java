/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientVacctinationRenouncement;

/**
 * @author gavr
 *
 */
public interface PatientVacctinationRenouncementDAO {

	public PatientVacctinationRenouncement findPatientVacctinationRenouncement(
			Integer patientId, Integer vacctinationId);

	public void savePatientVacctinationRenouncement(PatientVacctinationRenouncement renouncement);

	public List<PatientVacctinationRenouncement> findRecouncementVacctination(
			Integer institutionId, DateType dateType, List<Integer> vactinationIds);

	public List<PatientVacctinationRenouncement> findRenouncements(
			Integer patientId);

}
