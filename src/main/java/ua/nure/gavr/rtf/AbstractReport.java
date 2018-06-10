/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.rtf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Locale;

import net.sourceforge.rtf.RTFTemplate;
import net.sourceforge.rtf.helper.RTFTemplateBuilder;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;

import com.lowagie.text.rtf.document.RtfDocument;

/**
 *
 * @author testtest
 */
public abstract class AbstractReport {
	protected final Medemployee medEmployee;
	protected final Institution institution;
	protected final MessageSource messageSource;

	public AbstractReport(MessageSource messageSource, Medemployee medEmployee, Institution institution) {
		this.messageSource = messageSource;
		this.medEmployee = medEmployee;
		this.institution = institution;
	}

	public void buildReport(Writer writer) {

		String rtfSource = getTemplatePath();

		RTFTemplateBuilder builder = RTFTemplateBuilder.newRTFTemplateBuilder();
		RTFTemplate rtfTemplate;
		try {
			rtfTemplate = builder.newRTFTemplate();
			rtfTemplate.setTemplate(getClass().getResourceAsStream(rtfSource));

			fillModelData(rtfTemplate);
			rtfTemplate.merge(writer);
		} catch (Exception ex) {
			ex.printStackTrace();
			// Logger.getLogger(DonorRezervCard.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

	}

	protected abstract void fillModelData(RTFTemplate rtfTemplate);

	public String escape(String sentence) {
		if (sentence == null) {
			return null;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			new RtfDocument().filterSpecialChar(baos, sentence, true, true);
		} catch (IOException e) {
			// will never happen for ByteArrayOutputStream
		}
		return new String(baos.toByteArray());
	}

	protected abstract String getTemplatePath();

	protected String getLocalePath(String template) {
		return new StringBuilder().append(template).append("_")
			.append(LocaleContextHolder.getLocale().getCountry()).append(".rtf").toString();
	}

	protected String getAgeString(Date birthdate, Date vacctinationDate) {
		DateTime sd = new DateTime(birthdate.getTime());
		DateTime ed = new DateTime(vacctinationDate.getTime());
		Days d = Days.daysBetween(sd, ed);
		int days = d.getDays();
		Months m = Months.monthsBetween(sd, ed);
		int months = m.getMonths();
		Years y = Years.yearsBetween(sd, ed);
		int years = y.getYears();
		StringBuilder str = new StringBuilder();
		Locale locale = LocaleContextHolder.getLocale();
		String monthsStr = messageSource.getMessage("int.month.code", null, "м.", locale);
		String yearStr = messageSource.getMessage("int.year.code", null, "г.", locale);
		String dayStr = messageSource.getMessage("int.day.code", null, "д.", locale);

		if (years > 0) {
			str.append(years).append(" ").append(yearStr);
			str.append(" ").append(months % 12).append(" ").append(monthsStr);
		} else {
			if (months > 0) {
				str.append(months).append(" ").append(monthsStr);;
			} else {
				str.append(days).append(" ").append(" ").append(dayStr);
			}
		}
		return str.toString();
	}


}
