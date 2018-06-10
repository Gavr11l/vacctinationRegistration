/**
 *
 */
package ua.nure.gavr.rtf;

import java.util.Calendar;

import net.sourceforge.rtf.RTFTemplate;

import org.springframework.context.MessageSource;

import ua.nure.gavr.data.RenouncementWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.util.NamesHelper;
import ua.nure.gavr.util.StringUtils;

/**
 * @author gavr
 *
 */
public class PatientRenouncementReport extends AbstractReport{
	private static final String TEMPLATE_PATH = "/templates/t7";

	private final RenouncementWrapper renouncementWrapper;

	public PatientRenouncementReport(MessageSource messageSource, Medemployee medEmployee, Institution institution,
			RenouncementWrapper renouncementWrapper) {
		super(messageSource, medEmployee, institution);
		this.renouncementWrapper = renouncementWrapper;
	}

	public static PatientRenouncementReport instanceOf(MessageSource messageSource, Medemployee medEmployee,
			Institution institution, RenouncementWrapper renouncementWrapper) {
		return new PatientRenouncementReport(messageSource, medEmployee, institution, renouncementWrapper);
	}

	@Override
	protected String getTemplatePath() {
		return getLocalePath(TEMPLATE_PATH);
	}

	@Override
	protected void fillModelData(RTFTemplate rtfTemplate) {
		rtfTemplate.put("lastName", escape(renouncementWrapper.getPatient()
				.getLastName()));
		rtfTemplate.put("firstName", escape(renouncementWrapper.getPatient()
				.getFirstName()));
		rtfTemplate.put("middleName", escape(renouncementWrapper.getPatient()
				.getMiddleName()));
		rtfTemplate.put("birthDay", escape(StringUtils.formatDate(renouncementWrapper
				.getPatient().getBirthday())));
		rtfTemplate.put("vacctinationName", escape(renouncementWrapper
				.getVacctinaionFullName().getFullName()));
		rtfTemplate.put("renouncementDate", escape(StringUtils
				.formatDate(renouncementWrapper.getPatientVacctinationRenouncement()
						.getRenouncementDate())));
		rtfTemplate.put("renouncementTime", escape(renouncementWrapper.getPatientVacctinationRenouncement()
				.getRenouncementTime()));
		rtfTemplate.put("patientParent", escape(renouncementWrapper.getPatientParent().getLastName()+" " + renouncementWrapper.getPatientParent().getFirstName()+" " +renouncementWrapper.getPatientParent().getMiddleName()));


		rtfTemplate.put("institutionName",
				escape(NamesHelper.getInstitution(institution)));
		rtfTemplate.put("employer",
				escape(NamesHelper.getEmployerName(medEmployee)));
		rtfTemplate
				.put("currentDate", escape(StringUtils.formatDate(Calendar
						.getInstance().getTime())));
	}
}
