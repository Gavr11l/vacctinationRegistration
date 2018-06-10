/**
 *
 */
package ua.nure.gavr.web.addcalendarplandata;

import java.util.Date;
import java.util.List;

import ua.nure.gavr.data.CalendarPlanWrapper;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationListCommand;

/**
 * @author gavr
 *
 */
public class AddCalendarPlanDataCommand extends AbstractVacctinationListCommand<CalendarPlanWrapper>{

	private List<Integer> yearList;
	private Integer year;

	private List<Patient> patientList;
	private List<Vacctination> vacctinationList2;

	private Integer patientId;
	private Integer vacctinationId;
	private Date vacctinationDate;
	private Integer pcpid;

	private boolean addSuccessfull;
	private boolean editMode;



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

	public List<Vacctination> getVacctinationList2() {
		return vacctinationList2;
	}

	public void setVacctinationList2(List<Vacctination> vacctinationList2) {
		this.vacctinationList2 = vacctinationList2;
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

	public Date getVacctinationDate() {
		return vacctinationDate;
	}

	public void setVacctinationDate(Date vacctinationDate) {
		this.vacctinationDate = vacctinationDate;
	}

	public boolean isAddSuccessfull() {
		return addSuccessfull;
	}

	public void setAddSuccessfull(boolean addSuccessfull) {
		this.addSuccessfull = addSuccessfull;
	}

	public Integer getPcpid() {
		return pcpid;
	}

	public void setPcpid(Integer pcpid) {
		this.pcpid = pcpid;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}




}
