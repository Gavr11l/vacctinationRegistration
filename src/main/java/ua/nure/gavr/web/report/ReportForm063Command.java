/**
 *
 */
package ua.nure.gavr.web.report;

import java.util.List;

import ua.nure.gavr.model.Patient;
import ua.nure.gavr.web.abstractclasses.AbstractCommand;

/**
 * @author gavr
 *
 */
public class ReportForm063Command extends AbstractCommand {
	private Patient patient;



	private List<Integer> yearList;
	private Integer year;

	private List<Patient> patientList;
	private Integer patientId;
	public List<Integer> getYearList() {
		return yearList;
	}
	public void setYearList(List<Integer> yearList) {
		this.yearList = yearList;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public List<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}




	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
