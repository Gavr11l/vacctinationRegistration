package ua.nure.gavr.util;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.model.Vacctination;

/**
 *
 * @author testtest
 */
public class NamesHelper {

    public static String getEmployerName(Medemployee medEmployer) {
	return medEmployer.getLastName() + " "
		+ medEmployer.getFirstName() + " "
		+ medEmployer.getMiddleName();
    }

    public static String getEmployerPost(Medemployee medEmployer) {
	return medEmployer.getPost();
    }

    public static String getParentName(PatientParent parent) {
	return parent.getLastName() + " "
		+ parent.getFirstName() + " "
		+ parent.getMiddleName();
    }

    public static String getInstitution(Institution institution) {
	return institution.getInstitutionName();
    }

    public static String getVacctination(Vacctination vacctination) {
	return vacctination.getVacctinationType();
    }

    public static String getPatientName(Patient patient) {
	return patient.getLastName() + " "
		+ patient.getFirstName() + " "
		+ patient.getMiddleName() + "      "
		+ "Дата рождения: "
		+ patient.getBirthday();
    }

    public static String getAgeString(Date birthdate, Date vacctinationDate) {
	DateTime sd = new DateTime(birthdate.getTime());
	DateTime ed = new DateTime(vacctinationDate.getTime());
	Days d = Days.daysBetween(sd, ed);
	int days = d.getDays();
	Months m = Months.monthsBetween(sd, ed);
	int months = m.getMonths();
	Years y = Years.yearsBetween(sd, ed);
	int years = y.getYears();
	StringBuilder str = new StringBuilder();
	if (years > 0) {
	    str.append("Rokiv: ").append(years);
	    str.append("Misyaciv: ").append(months % 12);
	} else {
	    if (months > 0) {
		str.append("Misyaciv: ").append(months);
	    } else {
		str.append("Dniv: ").append(days);
	    }
	}
	return str.toString();
    }

    public static DateMargin getDateMargin(DateType dateType) {
	Date startDate = null;
	Date endDate = null;
	Calendar calendar = Calendar.getInstance();
	calendar.set(Calendar.HOUR, 0);
	calendar.set(Calendar.MINUTE, 0);
	calendar.set(Calendar.SECOND, 0);
	calendar.set(Calendar.MILLISECOND, 0);
	switch (dateType) {
	    case CURRENT_DAY:
		startDate = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		endDate = calendar.getTime();
		break;
	    case CURRENT_MONTH:
		calendar.set(Calendar.DATE, 1);
		startDate = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		endDate = calendar.getTime();
		break;
	    case CURRENT_QUARTER:
		calendar.set(Calendar.DATE, 1);
		int currentMonth = calendar.get(Calendar.MONTH);
		int startMonth = currentMonth < 4 ? 0 : currentMonth < 8 ? 4 : 8;
		calendar.set(Calendar.MONTH, startMonth);
		startDate = calendar.getTime();
		if (startMonth == 8) {
		    calendar.add(Calendar.YEAR, 1);
		    calendar.set(Calendar.MONTH, 0);
		} else {
		    calendar.set(Calendar.MONTH, startMonth + 4);
		}
		endDate = calendar.getTime();
		break;
	    case CURRENT_HALF_YEAR:
		calendar.set(Calendar.DATE, 1);
		currentMonth = calendar.get(Calendar.MONTH);
		startMonth = currentMonth < 6 ? 0 : 6;
		calendar.set(Calendar.MONTH, startMonth);
		startDate = calendar.getTime();
		if (startMonth == 6) {
		    calendar.add(Calendar.YEAR, 1);
		    calendar.set(Calendar.MONTH, 0);
		} else {
		    calendar.set(Calendar.MONTH, startMonth + 6);
		}
		endDate = calendar.getTime();
		break;
	    case CURRENT_YEAR:
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.MONTH, 0);
		startDate = calendar.getTime();
		calendar.add(Calendar.YEAR, 1);
		endDate = calendar.getTime();
		break;
	}
	return new DateMargin(startDate, endDate);
    }

}
