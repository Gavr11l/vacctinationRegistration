/**
 *
 */
package ua.nure.gavr.web.fault.add;

import java.util.Date;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationAddCommand;

/**
 * @author gavr
 *
 */
public class AddVacctinationFaultDataCommand extends AbstractVacctinationAddCommand<PatientCalendarPlan> {
	private String faultReason;
	private String faultTime;
	private Date vacctinationDate;

	public String getFaultReason() {
		return faultReason;
	}

	public void setFaultReason(String faultReason) {
		this.faultReason = faultReason;
	}

	public String getFaultTime() {
		return faultTime;
	}

	public void setFaultTime(String faultTime) {
		this.faultTime = faultTime;
	}

	public Date getVacctinationDate() {
		return vacctinationDate;
	}

	public void setVacctinationDate(Date vacctinationDate) {
		this.vacctinationDate = vacctinationDate;
	}

}
