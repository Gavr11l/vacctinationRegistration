package ua.nure.gavr.rtf;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sourceforge.rtf.RTFTemplate;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.FaultWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.rtf.model.FaultRecord;
import ua.nure.gavr.util.DateMargin;
import ua.nure.gavr.util.NamesHelper;
import ua.nure.gavr.util.StringUtils;

public class FaultReport  extends AbstractReport {
	private static final String TEMPLATE_PATH = "/templates/t2";

	private final DateType dateType;
	private final List<FaultWrapper> faultWrapperList;

	private FaultReport(MessageSource messageSource, Medemployee medEmployee,
			Institution institution, List<FaultWrapper> faultWrapperList,
			DateType dateType) {
		super(messageSource, medEmployee, institution);
		this.faultWrapperList = faultWrapperList;
		this.dateType = dateType;
	}

	public static FaultReport instanceOf(MessageSource messageSource,
			Medemployee medEmployee, Institution institution,
			List<FaultWrapper> faultWrapperList, DateType dateType) {
		return new FaultReport(messageSource, medEmployee, institution,
				faultWrapperList, dateType);
	}

	@Override
	protected void fillModelData(RTFTemplate rtfTemplate) {
		List<FaultRecord> table = new ArrayList<>();
		int count = 1;
		for (FaultWrapper wrapper : faultWrapperList) {
			table.add(new FaultRecord(escape(String.valueOf(count++)),
					escape(wrapper.getPatient().getFirstName()), escape(wrapper
							.getPatient().getLastName()), escape(wrapper
							.getPatient().getMiddleName()), escape(StringUtils
							.formatDate(wrapper.getPatient().getBirthday())),
					escape(wrapper.getVacctinaionFullName().getFullName()),
					escape(StringUtils.formatDate(wrapper
							.getPatientVacctinationFault().getVacctinationFaultDate()))));
		}
		DateMargin dateMargin = NamesHelper.getDateMargin(dateType);
		StringBuilder title = new StringBuilder();

		String msg = messageSource.getMessage("some.code", null, "Звіт по медичним відведенням.\nза період:",
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
