/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.rtf;

import java.util.Calendar;

import net.sourceforge.rtf.RTFTemplate;

import org.springframework.context.MessageSource;

import ua.nure.gavr.data.VacctinationWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.util.NamesHelper;
import ua.nure.gavr.util.StringUtils;

/**
 *
 * @author testtest
 */
public class VacctinationReport extends AbstractReport {
	private static final String TEMPLATE_PATH = "/templates/t4";

	private final VacctinationWrapper vaccWrapper;

	public VacctinationReport(MessageSource messageSource, Medemployee medEmployee, Institution institution,
			VacctinationWrapper vaccWrapper) {
		super(messageSource, medEmployee, institution);
		this.vaccWrapper = vaccWrapper;
	}

	public static VacctinationReport instanceOf(MessageSource messageSource, Medemployee medEmployee,
			Institution institution, VacctinationWrapper vaccWrapper) {
		return new VacctinationReport(messageSource, medEmployee, institution, vaccWrapper);
	}

	@Override
	protected String getTemplatePath() {
		return getLocalePath(TEMPLATE_PATH);
	}

	@Override
	protected void fillModelData(RTFTemplate rtfTemplate) {
		rtfTemplate.put("lastName", escape(vaccWrapper.getPatient()
				.getLastName()));
		rtfTemplate.put("firstName", escape(vaccWrapper.getPatient()
				.getFirstName()));
		rtfTemplate.put("middleName", escape(vaccWrapper.getPatient()
				.getMiddleName()));
		rtfTemplate.put("birthDay", escape(StringUtils.formatDate(vaccWrapper
				.getPatient().getBirthday())));
		rtfTemplate.put("vacctinationName", escape(vaccWrapper
				.getVacctinaionFullName().getFullName()));
		rtfTemplate.put("dose", escape(String.valueOf(vaccWrapper
				.getPatientVacctinaion().getDose())));
		rtfTemplate.put("vacctinationDate", escape(StringUtils
				.formatDate(vaccWrapper.getPatientVacctinaion()
						.getVacctinationDate())));
		rtfTemplate.put("series", escape(vaccWrapper.getPatientVacctinaion()
				.getSeries()));
		if (vaccWrapper.getPatientVacctinationResult() != null) {
			rtfTemplate.put("result", escape(vaccWrapper
					.getPatientVacctinationResult().getResult()));
			rtfTemplate.put("localReaction", escape(vaccWrapper
					.getPatientVacctinationResult().getLocalReaction()));
			rtfTemplate.put("globalReaction", escape(vaccWrapper
					.getPatientVacctinationResult().getGlobalReaction()));
		} else {
			rtfTemplate.put("result", "");
			rtfTemplate.put("localReaction", "");
			rtfTemplate.put("globalReaction", "");
		}
		rtfTemplate.put("institutionName",
				escape(NamesHelper.getInstitution(institution)));
		rtfTemplate.put("employer",
				escape(NamesHelper.getEmployerName(medEmployee)));
		rtfTemplate
				.put("currentDate", escape(StringUtils.formatDate(Calendar
						.getInstance().getTime())));
	}
}
