/**
 *
 */
package ua.nure.gavr.rtf;

import java.util.Calendar;

import net.sourceforge.rtf.RTFTemplate;

import org.springframework.context.MessageSource;

import ua.nure.gavr.data.FaultWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.util.NamesHelper;
import ua.nure.gavr.util.StringUtils;

/**
 * @author gavr
 *
 */
public class PatientFaultReport extends AbstractReport{
	private static final String TEMPLATE_PATH = "/templates/t5";

	private final FaultWrapper faultWrapper;

	public PatientFaultReport(MessageSource messageSource, Medemployee medEmployee, Institution institution,
			FaultWrapper faultWrapper) {
		super(messageSource, medEmployee, institution);
		this.faultWrapper = faultWrapper;
	}

	public static PatientFaultReport instanceOf(MessageSource messageSource, Medemployee medEmployee,
			Institution institution, FaultWrapper faultWrapper) {
		return new PatientFaultReport(messageSource, medEmployee, institution, faultWrapper);
	}

	@Override
	protected String getTemplatePath() {
		return getLocalePath(TEMPLATE_PATH);
	}

	@Override
	protected void fillModelData(RTFTemplate rtfTemplate) {
		rtfTemplate.put("lastName", escape(faultWrapper.getPatient()
				.getLastName()));
		rtfTemplate.put("firstName", escape(faultWrapper.getPatient()
				.getFirstName()));
		rtfTemplate.put("middleName", escape(faultWrapper.getPatient()
				.getMiddleName()));
		rtfTemplate.put("birthDay", escape(StringUtils.formatDate(faultWrapper
				.getPatient().getBirthday())));
		rtfTemplate.put("vacctinationName", escape(faultWrapper
				.getVacctinaionFullName().getFullName()));
		rtfTemplate.put("vacctinationFaultDate", escape(StringUtils
				.formatDate(faultWrapper.getPatientVacctinationFault()
						.getVacctinationFaultDate())));
		rtfTemplate.put("faultTime", escape(faultWrapper.getPatientVacctinationFault()
				.getFaultTime()));
		rtfTemplate.put("faultReason", escape(faultWrapper.getPatientVacctinationFault()
				.getFaultReason()));


		rtfTemplate.put("institutionName",
				escape(NamesHelper.getInstitution(institution)));
		rtfTemplate.put("employer",
				escape(NamesHelper.getEmployerName(medEmployee)));
		rtfTemplate
				.put("currentDate", escape(StringUtils.formatDate(Calendar
						.getInstance().getTime())));
	}
}
