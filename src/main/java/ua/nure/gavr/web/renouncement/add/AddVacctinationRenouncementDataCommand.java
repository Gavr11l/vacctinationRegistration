/**
 *
 */
package ua.nure.gavr.web.renouncement.add;

import java.util.Date;
import java.util.List;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationAddCommand;

/**
 * @author gavr
 *
 */
public class AddVacctinationRenouncementDataCommand extends AbstractVacctinationAddCommand<PatientCalendarPlan> {

	private List<PatientParent> patientParentList;
	private Integer patientParentId;
	private Integer parentId;

	private String renouncementTime;
	private Date vacctinationDate;

	public String getRenouncementTime() {
		return renouncementTime;
	}

	public void setRenouncementTime(String renouncementTime) {
		this.renouncementTime = renouncementTime;
	}

	public Date getVacctinationDate() {
		return vacctinationDate;
	}

	public void setVacctinationDate(Date vacctinationDate) {
		this.vacctinationDate = vacctinationDate;
	}

	public List<PatientParent> getPatientParentList() {
		return patientParentList;
	}

	public void setPatientParentList(List<PatientParent> patientParentList) {
		this.patientParentList = patientParentList;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}



	public Integer getPatientParentId() {
		return patientParentId;
	}

	public void setPatientParentId(Integer patientParentId) {
		this.patientParentId = patientParentId;
	}


}
