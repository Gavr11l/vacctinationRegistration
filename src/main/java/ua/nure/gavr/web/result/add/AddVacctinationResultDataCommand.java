/**
 *
 */
package ua.nure.gavr.web.result.add;

import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.web.abstractclasses.AbstractVacctinationAddCommand;

/**
 * @author gavr
 *
 */
public class AddVacctinationResultDataCommand extends AbstractVacctinationAddCommand<PatientVacctination> {
	private String reactionLocal;
	private String reactionGlobal;
	private String result;

	public String getReactionLocal() {
		return reactionLocal;
	}

	public void setReactionLocal(String reactionLocal) {
		this.reactionLocal = reactionLocal;
	}

	public String getReactionGlobal() {
		return reactionGlobal;
	}

	public void setReactionGlobal(String reactionGlobal) {
		this.reactionGlobal = reactionGlobal;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


}
