/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientVacctinationFault;

/**
 * @author gavr
 *
 */
public interface PatientVacctinationFaultDAO {

	public void savePatientVacctinationFaultResult(PatientVacctinationFault patientVacctinationFault);

	public PatientVacctinationFault findPatientVacctinationFault(Integer patientId, Integer vacctinationId);

	public List<PatientVacctinationFault> findFaultVacctination(Integer institutionId,
			DateType dateType, List<Integer> vacctinationIds);

	public List<PatientVacctinationFault> findFaults(Integer patientId);

}
