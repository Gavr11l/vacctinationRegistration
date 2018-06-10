/**
 *
 */
package ua.nure.gavr.rtf.model;

/**
 * @author gavr
 *
 */
public class RenouncementRecord extends AbstractRecord {

	private String vacctinationRenouncementDate;

	public RenouncementRecord(String number, String firstName, String lastName,
			String middleName, String birthDay, String vacctinationName,
			String vacctinationRenouncementDate) {
		super(number, firstName, lastName, middleName, birthDay, vacctinationName);
		this.vacctinationRenouncementDate = vacctinationRenouncementDate;
	}

	public String getvacctinationRenouncementDate() {
		return vacctinationRenouncementDate;
	}

}
