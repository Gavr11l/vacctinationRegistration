/**
 *
 */
package ua.nure.gavr.rtf.model;

/**
 * @author gavr
 *
 */
public abstract class AbstractRecord {

	private String number;
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthDay;
	private String vacctinationName;

	public AbstractRecord(String number, String firstName, String lastName,
			String middleName, String birthDay, String vacctinationName) {
		super();
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.birthDay = birthDay;
		this.vacctinationName = vacctinationName;
	}

	public String getNumber() {
		return number;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getVacctinationName() {
		return vacctinationName;
	}

}
