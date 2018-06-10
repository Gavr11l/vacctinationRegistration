/**
 *
 */
package ua.nure.gavr.rtf;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import net.sourceforge.rtf.RTFTemplate;

import org.springframework.context.MessageSource;

import ua.nure.gavr.data.PattientVacctinationsDataWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationFault;
import ua.nure.gavr.model.PatientVacctinationResult;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.util.StringUtils;

/**
 * @author gavr
 *
 */
public class Form063Report extends AbstractReport{
	private static final String TEMPLATE_PATH = "/templates/t6";
	 Date date = new Date();

	private final PattientVacctinationsDataWrapper dataWrapper;

	private Form063Report(MessageSource messageSource, Medemployee medEmployee,
			Institution institution,
			PattientVacctinationsDataWrapper pattientVacctinationsDataWrapper) {
		super(messageSource, medEmployee, institution);
		this.dataWrapper = pattientVacctinationsDataWrapper;
	}

	public static Form063Report instanceOf(MessageSource messageSource, Medemployee medEmployee,
			Institution institution,
			PattientVacctinationsDataWrapper pattientVacctinationsDataWrapper) {
		return new Form063Report(messageSource, medEmployee, institution, pattientVacctinationsDataWrapper);
	}

	@Override
	protected void fillModelData(RTFTemplate rtfTemplate) {
		Institution institution = dataWrapper.getInstitution();
		rtfTemplate.put("institutionName", escape(institution.getInstitutionName().toString()));

		Patient patient = dataWrapper.getPatient();
		rtfTemplate.put("lastNamePatient", escape(patient.getLastName().toString()));
		rtfTemplate.put("firstNamePatient", escape(patient.getFirstName().toString()));
		rtfTemplate.put("middleNamePatient", escape(patient.getMiddleName().toString()));
		rtfTemplate.put("sex", escape(patient.getSex().toString()));
		rtfTemplate.put("residArea", escape(patient.getPlaceOfResidenceArea().toString()));
		rtfTemplate.put("residDistrict", escape(patient.getPlaceOfResidenceDistrict().toString()));
		rtfTemplate.put("residCity", escape(patient.getPlaceOfResidenceCity().toString()));
		rtfTemplate.put("residHouse", escape(Integer.toString(patient.getPlaceOfResidenceHouseNumber())));
		rtfTemplate.put("residStreet", escape(patient.getPlaceOfResidenceStreet().toString()));
		if(patient.getPlaceOfResidenceHousingNumber() != null) {
			rtfTemplate.put("residCorpus", escape(patient.getPlaceOfResidenceHousingNumber().toString()));
		}
		if (patient.getPlaceOfResidenceFlatNumber() != null){
		rtfTemplate.put("residFlat", escape(patient.getPlaceOfResidenceFlatNumber().toString()));
		}
		rtfTemplate.put("bd", escape(StringUtils.formatDate(patient.getBirthday())));
		rtfTemplate.put("cd", escape(StringUtils.formatDate(date)));


		Vacctination vVT = dataWrapper.getVacctination("ВТ");
		fillVTRecord(rtfTemplate, vVT, "VT");
		Vacctination rVTf = dataWrapper.getVacctination("PВT");
		fillVTRecord(rtfTemplate, rVTf, "RVTf");


		Vacctination vAKDSf = dataWrapper.getVacctination("АКДС+П(1)");
		fillVAKDSRecord(rtfTemplate, vAKDSf, "VAKDSf");
		Vacctination vAKDSs = dataWrapper.getVacctination("АКДС+П(2)");
		fillVAKDSRecord(rtfTemplate, vAKDSs, "VAKDSs");
		Vacctination vAKDSt = dataWrapper.getVacctination("АКДС+П(3)");
		fillVAKDSRecord(rtfTemplate, vAKDSt, "VAKDSt");
		Vacctination rVAKDSf = dataWrapper.getVacctination("АКДС+П(4)");
		fillVAKDSRecord(rtfTemplate, rVAKDSf, "RVAKDSf");
		Vacctination vKPKf = dataWrapper.getVacctination("КПК(1)");
		fillVAKDSRecord(rtfTemplate, vKPKf, "VKPKf");
		Vacctination vKPKs = dataWrapper.getVacctination("КПК(2)");
		fillVAKDSRecord(rtfTemplate, vKPKs, "VKPKs");
		Vacctination vGf = dataWrapper.getVacctination("ГВ(1)");
		fillVAKDSRecord(rtfTemplate, vGf, "VGf");
		Vacctination vGs = dataWrapper.getVacctination("ГВ(2)");
		fillVAKDSRecord(rtfTemplate, vGs, "VGs");
		Vacctination vGt = dataWrapper.getVacctination("ГВ(3)");
		fillVAKDSRecord(rtfTemplate, vGt, "VGt");

		Vacctination tf = dataWrapper.getVacctination("Т(1)");
		fillTRecord(rtfTemplate, tf, "Tf");
		Vacctination ts = dataWrapper.getVacctination("Т(2)");
		fillTRecord(rtfTemplate, ts, "Ts");
		Vacctination tt = dataWrapper.getVacctination("Т(3)");
		fillTRecord(rtfTemplate, tt, "Tt");
		Vacctination tfr = dataWrapper.getVacctination("Т(4)");
		fillTRecord(rtfTemplate, tfr, "Tfr");
		Vacctination tfv = dataWrapper.getVacctination("Т(5)");
		fillTRecord(rtfTemplate, tfv, "Tfv");
		Vacctination tsx = dataWrapper.getVacctination("Т(6)");
		fillTRecord(rtfTemplate, tsx, "Tsx");
		Vacctination tsv = dataWrapper.getVacctination("Т(7)");
		fillTRecord(rtfTemplate, tsv, "Tsv");


		String[] fields = new String[] {"institutionName","cd","numbSite","lastNamePatient",
				"firstNamePatient","middleNamePatient","bd","sex","residArea","residDistrict",
				"residCity","residCorpus","residFlat","ageVT","dateVT","doseVT","serVT","reacLocVT",
				"falDateVT","falReasonVT","ageRVTf","dateRVTf","doseRVTf","serRVTf","reacLocRVTf",
				"falDateRVTf","falReasonRVTf","ageRVTs","dateRVTs","doseRVTs","serRVTs","reacLocRVTs",
				"falDateRVTs","falReasonRVTs","ageVAKDSf","dateVAKDSf","doseVAKDSf","serVAKDSf",
				"falDateVAKDSf","falReasonVAKDSf","ageRVAKDSf","dateRVAKDSf","doseRVAKDSf","serRVAKDSf",
				"falDateRVAKDSf","falReasonRVAKDSf","ageVAKDSs","dateVAKDSs","doseVAKDSs","serVAKDSs",
				"falDateVAKDSs","falReasonVAKDSs","ageRVAKDSs","dateRVAKDSs","doseRVAKDSs","serRVAKDSs",
				"falDateRVAKDSs","falReasonRVAKDSs","ageVAKDSt","dateVAKDSt","doseVAKDSt","serVAKDSt",
				"falDateVAKDSt","falReasonVAKDSt","ageRVAKDSt","dateRVAKDSt","doseRVAKDSt","serRVAKDSt",
				"falDateRVAKDSt","falReasonRVAKDSt","reacGlbVAKDSf","reacLocVAKDSf","reacGlbVAKDSs",
				"reacLocVAKDSs","reacGlbVAKDSt","reacLocVAKDSt","reacGlbRVAKDSf","reacLocRVAKDSf",
				"reacGlbRVAKDSs","reacLocRVAKDSs","reacGlbRVAKDSt","reacLocRVAKDSt","ageVKPKf","dateVKPKf",
				"doseVKPKf","serVKPKf","reacGlbVKPKf","reacLocVKPKf","falDateVKPKf","falReasonVKPKf",
				"ageVKPKs","dateVKPKs","doseVKPKs","serVKPKs","reacGlbVKPKs","reacLocVKPKs","falDateVKPKs",
				"falReasonVKPKs","ageVGf","dateVGf","doseVGf","serVGf","reacGlbVGf","reacLocVGf","falDateVGf",
				"falReasonVGf","ageVGs","dateVGs","doseVGs","serVGs","reacGlbVGs","reacLocVGs","falDateVGs",
				"falReasonVGs","ageVGt","dateVGt","doseVGt","serVGt","reacGlbVGt","reacLocVGt","falDateVGt",
				"falReasonVGt","ageTf","dateTf","doseTf","serTf","resTf","ageTfv","dateTfv","doseTfv","serTfv",
				"resTfv","ageTn","dateTn","doseTn","serTn","resTn","ageTs","dateTs","doseTs","serTs","resTs",
				"ageTsx","dateTsx","doseTsx","serTsx","resTsx","ageTtn","dateTtn","doseTtn","serTtn","resTtn",
				"ageTt","dateTt","doseTt","serTt","resTt","ageTsv","dateTsv","doseTsv","serTsv","resTsv","ageTfr",
				"dateTfr","doseTfr","serTfr","resTfr","ageTe","dateTe","doseTe","serTe","resTe"};

		for (String field : fields) {
			if(rtfTemplate.getContext().get(field) == null)
				rtfTemplate.put(field, "");

		}



	}

	private void fillVTRecord(RTFTemplate rtfTemplate, Vacctination vVT, String sufix) {
		if(vVT != null) {
			PatientVacctination pv = dataWrapper.getPatientVacctination(vVT.getIdVacctination());
			if(pv != null) {
				rtfTemplate.put(getField("dose", sufix), pv.getDose());
				rtfTemplate.put(getField("ser", sufix), pv.getSeries());
				rtfTemplate.put(getField("date", sufix), StringUtils.formatDate(pv.getVacctinationDate()));
				rtfTemplate.put(getField("age", sufix), getAgeString(dataWrapper.getPatient().getBirthday(), pv.getVacctinationDate()));

				PatientVacctinationResult result = dataWrapper.getPatientVacctinationResult(pv.getIdPatientVacctination());
				if(result != null) {
					rtfTemplate.put(getField("reacLoc", sufix), result.getLocalReaction());
				}

				List<PatientVacctinationFault> faults = dataWrapper.getPatientVacctinationFaults(pv.getIdPatientVacctination());
				if(faults != null && !faults.isEmpty()) {
					Collections.sort(faults, Collections.reverseOrder(new Comparator<PatientVacctinationFault>() {
						@Override
						public int compare(PatientVacctinationFault o1,
								PatientVacctinationFault o2) {
							return o1.getVacctinationFaultDate().compareTo(o2.getVacctinationFaultDate());
						}
					}));
					PatientVacctinationFault fault = faults.iterator().next();
					if(fault != null) {
						rtfTemplate.put(getField("falDate", sufix), fault.getVacctinationFaultDate());
						rtfTemplate.put(getField("falReason", sufix), fault.getFaultReason());
					}
				}
			}
		}
	}


	private void fillVAKDSRecord(RTFTemplate rtfTemplate, Vacctination rVAKDSf, String sufix) {
		if(rVAKDSf != null) {
			PatientVacctination pv = dataWrapper.getPatientVacctination(rVAKDSf.getIdVacctination());
			if(pv != null) {
				rtfTemplate.put(getField("dose", sufix), pv.getDose());
				rtfTemplate.put(getField("ser", sufix), pv.getSeries());
				rtfTemplate.put(getField("date", sufix), StringUtils.formatDate(pv.getVacctinationDate()));
				rtfTemplate.put(getField("age", sufix), getAgeString(dataWrapper.getPatient().getBirthday(), pv.getVacctinationDate()));

				PatientVacctinationResult result = dataWrapper.getPatientVacctinationResult(pv.getIdPatientVacctination());
				if(result != null) {
					rtfTemplate.put(getField("reacGlb", sufix), result.getGlobalReaction());
					rtfTemplate.put(getField("reacLoc", sufix), result.getLocalReaction());
				}
				List<PatientVacctinationFault> faults = dataWrapper.getPatientVacctinationFaults(pv.getIdPatientVacctination());
				if(faults != null && !faults.isEmpty()) {
					Collections.sort(faults, Collections.reverseOrder(new Comparator<PatientVacctinationFault>() {
						@Override
						public int compare(PatientVacctinationFault o1,
								PatientVacctinationFault o2) {
							return o1.getVacctinationFaultDate().compareTo(o2.getVacctinationFaultDate());
						}
					}));
					PatientVacctinationFault fault = faults.iterator().next();
				if(fault != null) {
					rtfTemplate.put(getField("falDate", sufix), fault.getVacctinationFaultDate());
					rtfTemplate.put(getField("falReason", sufix), fault.getFaultReason());

				}
				}
			}
		}
	}

	private void fillTRecord(RTFTemplate rtfTemplate, Vacctination tf, String sufix) {
		if(tf != null) {
			PatientVacctination pv = dataWrapper.getPatientVacctination(tf.getIdVacctination());
			if(pv != null) {
				rtfTemplate.put(getField("dose", sufix), pv.getDose());
				rtfTemplate.put(getField("ser", sufix), pv.getSeries());
				rtfTemplate.put(getField("date", sufix), StringUtils.formatDate(pv.getVacctinationDate()));
				rtfTemplate.put(getField("age", sufix), getAgeString(dataWrapper.getPatient().getBirthday(), pv.getVacctinationDate()));

				PatientVacctinationResult result = dataWrapper.getPatientVacctinationResult(pv.getIdPatientVacctination());
				if(result != null) {
					rtfTemplate.put(getField("res", sufix), result.getResult());
				}


			}
		}
	}


	private String getField(String field, String sufix) {
		return new StringBuilder(field).append(sufix).toString();
	}

	@Override
	protected String getTemplatePath() {
		return getLocalePath(TEMPLATE_PATH);
	}


}
