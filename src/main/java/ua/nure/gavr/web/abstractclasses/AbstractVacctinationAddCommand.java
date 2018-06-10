/**
 *
 */
package ua.nure.gavr.web.abstractclasses;


/**
 * @author gavr
 *
 */
public abstract class AbstractVacctinationAddCommand<T> extends AbstractVacctinationViewCommand<T> {
	private boolean addSuccessfull;

	public boolean isAddSuccessfull() {
		return addSuccessfull;
	}
	public void setAddSuccessfull(boolean addSuccessfull) {
		this.addSuccessfull = addSuccessfull;
	}

}
