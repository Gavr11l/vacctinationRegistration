/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.rtf.model;

/**
 *
 * @author testtest
 */
public class InstitutionRecord extends AbstractRecord {
	private String vacctinationDate;

	public InstitutionRecord(String number, String firstName, String lastName,
			String middleName, String birthDay, String vacctinationName,
			String vacctinationDate) {
		super(number, firstName, lastName, middleName, birthDay, vacctinationName);
		this.vacctinationDate = vacctinationDate;
	}

	public String getVacctinationDate() {
		return vacctinationDate;
	}

}
