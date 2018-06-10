/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.rtf;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sourceforge.rtf.RTFTemplate;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.VacctinationWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.rtf.model.InstitutionRecord;
import ua.nure.gavr.util.DateMargin;
import ua.nure.gavr.util.NamesHelper;
import ua.nure.gavr.util.StringUtils;

/**
 *
 * @author testtest
 */
public class InstitutionReport extends AbstractReport {
	private static final String TEMPLATE_PATH = "/templates/t1";

	private final DateType dateType;
	private final List<VacctinationWrapper> vaccWrapperList;

	private InstitutionReport(MessageSource messageSource, Medemployee medEmployee,
			Institution institution, List<VacctinationWrapper> vaccWrapperList,
			DateType dateType) {
		super(messageSource, medEmployee, institution);
		this.vaccWrapperList = vaccWrapperList;
		this.dateType = dateType;
	}

	public static InstitutionReport instanceOf(MessageSource messageSource,
			Medemployee medEmployee, Institution institution,
			List<VacctinationWrapper> vaccWrapperList, DateType dateType) {
		return new InstitutionReport(messageSource, medEmployee, institution,
				vaccWrapperList, dateType);
	}

	@Override
	protected void fillModelData(RTFTemplate rtfTemplate) {
		List<InstitutionRecord> table = new ArrayList<>();
		int count = 1;
		for (VacctinationWrapper wrapper : vaccWrapperList) {
			table.add(new InstitutionRecord(escape(String.valueOf(count++)),
					escape(wrapper.getPatient().getFirstName()), escape(wrapper
							.getPatient().getLastName()), escape(wrapper
							.getPatient().getMiddleName()), escape(StringUtils
							.formatDate(wrapper.getPatient().getBirthday())),
					escape(wrapper.getVacctinaionFullName().getFullName()),
					escape(StringUtils.formatDate(wrapper
							.getPatientVacctinaion().getVacctinationDate()))));
		}
		DateMargin dateMargin = NamesHelper.getDateMargin(dateType);
		StringBuilder title = new StringBuilder();

		String msg = messageSource.getMessage("some.code", null, "Звіт по зробленим щепленням.\nза період:",
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
