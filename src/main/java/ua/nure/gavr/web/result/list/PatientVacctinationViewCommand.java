/**
 *
 */
package ua.nure.gavr.web.result.list;

import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationResult;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationViewCommand;

/**
 * @author gavr
 *
 */
public class PatientVacctinationViewCommand extends AbstractVacctinationViewCommand<PatientVacctination>{
	private PatientVacctinationResult vacctinationResult;

	public PatientVacctinationResult getVacctinationResult() {
		return vacctinationResult;
	}

	public void setVacctinationResult(PatientVacctinationResult vacctinationResult) {
		this.vacctinationResult = vacctinationResult;
	}


}
