/**
 *
 */
package ua.nure.gavr.web.vacctination.add;

import java.util.Date;

import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationAddCommand;

/**
 * @author gavr
 *
 */
public class AddVacctinationDataCommand extends AbstractVacctinationAddCommand<PatientCalendarPlan> {
	private double dose;
	private String series;
	private Date vacctinationDate;

	public double getDose() {
		return dose;
	}
	public void setDose(double dose) {
		this.dose = dose;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Date getVacctinationDate() {
		return vacctinationDate;
	}
	public void setVacctinationDate(Date vacctinationDate) {
		this.vacctinationDate = vacctinationDate;
	}

}
