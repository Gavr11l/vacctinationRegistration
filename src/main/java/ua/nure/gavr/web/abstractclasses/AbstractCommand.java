/**
 * 
 */
package ua.nure.gavr.web.abstractclasses;

import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;

/**
 * @author gavr
 *
 */
public class AbstractCommand {
	private Medemployee medEmployee;
	private Institution institution;
	
	public Medemployee getMedEmployee() {
		return medEmployee;
	}
	public void setMedEmployee(Medemployee medEmployee) {
		this.medEmployee = medEmployee;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
