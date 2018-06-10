/**
 *
 */
package ua.nure.gavr.rtf.model;

/**
 * @author gavr
 *
 */
public class FaultRecord extends AbstractRecord {

	private String vacctinationFaultDate;

	public FaultRecord(String number, String firstName, String lastName,
			String middleName, String birthDay, String vacctinationName,
			String vacctinationFaultDate) {
		super(number, firstName, lastName, middleName, birthDay, vacctinationName);
		this.vacctinationFaultDate = vacctinationFaultDate;
	}

	public String getvacctinationFaultDate() {
		return vacctinationFaultDate;
	}

}
