/**
 *
 */
package ua.nure.gavr.rtf;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sourceforge.rtf.RTFTemplate;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.RenouncementWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.rtf.model.RenouncementRecord;
import ua.nure.gavr.util.DateMargin;
import ua.nure.gavr.util.NamesHelper;
import ua.nure.gavr.util.StringUtils;

/**
 * @author gavr
 *
 */
public class RenouncementReport extends AbstractReport {
	private static final String TEMPLATE_PATH = "/templates/t3";

	private final DateType dateType;
	private final List<RenouncementWrapper> renouncementWrapperList;

	private RenouncementReport(MessageSource messageSource, Medemployee medEmployee,
			Institution institution, List<RenouncementWrapper> renouncementWrapperList,
			DateType dateType) {
		super(messageSource, medEmployee, institution);
		this.renouncementWrapperList = renouncementWrapperList;
		this.dateType = dateType;
	}

	public static RenouncementReport instanceOf(MessageSource messageSource,
			Medemployee medEmployee, Institution institution,
			List<RenouncementWrapper> renouncementWrapperList, DateType dateType) {
		return new RenouncementReport(messageSource, medEmployee, institution,
				renouncementWrapperList, dateType);
	}

	@Override
	protected void fillModelData(RTFTemplate rtfTemplate) {
		List<RenouncementRecord> table = new ArrayList<>();
		int count = 1;
		for (RenouncementWrapper wrapper : renouncementWrapperList) {
			table.add(new RenouncementRecord(escape(String.valueOf(count++)),
					escape(wrapper.getPatient().getFirstName()), escape(wrapper
							.getPatient().getLastName()), escape(wrapper
							.getPatient().getMiddleName()), escape(StringUtils
							.formatDate(wrapper.getPatient().getBirthday())),
					escape(wrapper.getVacctinaionFullName().getFullName()),
					escape(StringUtils.formatDate(wrapper.getPatientVacctinationRenouncement().getRenouncementDate()))));
		}
		DateMargin dateMargin = NamesHelper.getDateMargin(dateType);
		StringBuilder title = new StringBuilder();

		String msg = messageSource.getMessage("some.code", null, "Звіт по відмовам від вакцинації.\nза період:",
				LocaleContextHolder.getLocale());

		title.append(msg);
		title.append("\n").append(
				StringUtils.formatDate(dateMargin.getStartDate()));
		title.append(" - ");
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(dateMargin.getEndDate());
		endDate.add(Calendar.DATE, -1);
		title.append(StringUtils.formatDate(endDate.getTime()));

		rtfTemplate.put("tc", table);
		rtfTemplate.put("title", escape(title.toString()));
		rtfTemplate.put("institutionName",
				escape(NamesHelper.getInstitution(institution)));
		rtfTemplate.put("employer",
				escape(NamesHelper.getEmployerName(medEmployee)));
		rtfTemplate
				.put("currentDate", escape(StringUtils.formatDate(Calendar
						.getInstance().getTime())));
	}

	@Override
	protected String getTemplatePath() {
		return getLocalePath(TEMPLATE_PATH);
	}

}
