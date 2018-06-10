/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.model.PatientParent;

/**
 * @author gavr
 *
 */
public interface PatientParentDAO {

	public List<PatientParent> findParentList(Integer patientId);

	public PatientParent findPatientParent(Integer patientParentId);

}
