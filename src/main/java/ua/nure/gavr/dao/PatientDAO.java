/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.model.Patient;

/**
 * @author gavr
 *
 */
public interface PatientDAO {

	public Patient findPatient(Integer patientId);

	public List<Patient> findPatients(Integer institutionId, Integer year);

	public List<Integer> findPatientBirthYear();

	public List<Patient> findPatients(Integer institutionId);

}
