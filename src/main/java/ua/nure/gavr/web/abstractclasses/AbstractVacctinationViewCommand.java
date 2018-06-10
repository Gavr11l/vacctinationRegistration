/**
 *
 */
package ua.nure.gavr.web.abstractclasses;

import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.model.VacctinationFullName;

/**
 * @author gavr
 *
 */
public abstract class AbstractVacctinationViewCommand<T> extends AbstractCommand {
	private Patient patient;
	private Vacctination vacctination;
	private VacctinationFullName vacctinationFullName;
	private T domain;
	private Integer patientId;
	private Integer vacctinationId;

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Vacctination getVacctination() {
		return vacctination;
	}
	public void setVacctination(Vacctination vacctination) {
		this.vacctination = vacctination;
	}
	public VacctinationFullName getVacctinationFullName() {
		return vacctinationFullName;
	}
	public void setVacctinationFullName(VacctinationFullName vacctinationFullName) {
		this.vacctinationFullName = vacctinationFullName;
	}
	public T getDomain() {
		return domain;
	}
	public void setDomain(T domain) {
		this.domain = domain;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getVacctinationId() {
		return vacctinationId;
	}
	public void setVacctinationId(Integer vacctinationId) {
		this.vacctinationId = vacctinationId;
	}
}