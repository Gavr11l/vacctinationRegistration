/**
 *
 */
package ua.nure.gavr.web;

import javax.servlet.http.HttpSession;

import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.web.abstractclasses.AbstractCommand;

/**
 * @author gavr
 *
 */
public class SessionHelper {

	private static final String INSTITUTION = "institution";
	private static final String MED_EMPLOYEE = "medEmployee";

	public static void setMedemployee (HttpSession session, Medemployee medemployee) {
		session.setAttribute(MED_EMPLOYEE, medemployee);
	}
	public static void setInstitution (HttpSession session, Institution institution) {
		session.setAttribute(INSTITUTION, institution);
	}

	public static Medemployee getMedemployee (HttpSession session) {
		return (Medemployee) session.getAttribute(MED_EMPLOYEE);
	}
	public static Institution getInstitution (HttpSession session) {
		return (Institution) session.getAttribute(INSTITUTION);
	}

	public static void fillCommand(HttpSession session, AbstractCommand command) {
		command.setInstitution(getInstitution(session));
		command.setMedEmployee(getMedemployee(session));
	}

	public static void clearSession(HttpSession session) {
		session.removeAttribute(INSTITUTION);
		session.removeAttribute(MED_EMPLOYEE);
	}
}
