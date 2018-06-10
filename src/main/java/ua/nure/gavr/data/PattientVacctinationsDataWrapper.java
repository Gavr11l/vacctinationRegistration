/**
 *
 */
package ua.nure.gavr.data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationFault;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.model.PatientVacctinationResult;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.model.VacctinationFullName;

/**
 * @author gavr
 *
 */
public class PattientVacctinationsDataWrapper {
	private final Patient patient;
	private final Institution institution;

	private Map<String, Vacctination> vacctinationList;
	private Map<Integer, VacctinationFullName> vacctinationFullNames;

	private Map<Integer, PatientCalendarPlan> calendarPlans;
	private Map<Integer, PatientVacctination> vacctinations;
	private Map<Integer, PatientVacctinationResult> results;
	private Map<Integer, List<PatientVacctinationFault>> faults;
	private Map<Integer, PatientVacctinationRenouncement> renouncements;


	public PattientVacctinationsDataWrapper(Patient patient,
			Institution institution) {
		super();
		this.patient = patient;
		this.institution = institution;
	}

	public PattientVacctinationsDataWrapper setCalendarPlans(List<PatientCalendarPlan> calendarPlans) {
		this.calendarPlans = calendarPlans.stream().collect(Collectors.toMap(PatientCalendarPlan::getIdVacctination, cp -> cp));
		return this;
	}

	public PattientVacctinationsDataWrapper setVacctinations(List<PatientVacctination> vacctinations) {
		this.vacctinations = vacctinations.stream().collect(Collectors.toMap(PatientVacctination::getIdVacctination, v -> v));
		return this;
	}

	public PattientVacctinationsDataWrapper setResults(List<PatientVacctinationResult> results) {
		this.results = results.stream().collect(Collectors.toMap(PatientVacctinationResult::getIdPatientVacctination, v -> v));
		return this;
	}

	public PattientVacctinationsDataWrapper setFaults(List<PatientVacctinationFault> faults) {
		this.faults = faults.stream().collect(Collectors.groupingBy(fault -> fault.getIdVacctination()));

		return this;
	}

	public PattientVacctinationsDataWrapper setRenouncements(List<PatientVacctinationRenouncement> renouncements) {
		this.renouncements = renouncements.stream().collect(Collectors.toMap(PatientVacctinationRenouncement::getIdVacctination, v -> v));
		return this;
	}

	public PattientVacctinationsDataWrapper setVacctinationList(List<Vacctination> vacctinationList) {
		this.vacctinationList = vacctinationList.stream().collect(Collectors.toMap(Vacctination::getVacctinationType, v -> v));;
		return this;
	}

	public PattientVacctinationsDataWrapper setVacctinationFullNames(
			List<VacctinationFullName> vacctinationFullNames) {
		this.vacctinationFullNames = vacctinationFullNames.stream().collect(Collectors.toMap(VacctinationFullName::getIdVacctination, v -> v));
		return this;
	}


	public Patient getPatient() {
		return patient;
	}
	public Institution getInstitution() {
		return institution;
	}
	public Vacctination getVacctination(String code) {
		return vacctinationList.get(code);
	}

	public VacctinationFullName getVacctinationFullName(String code) {
		Vacctination vacctination = getVacctination(code);
		return vacctination != null ? vacctinationFullNames.get(vacctination.getIdVacctination()) : null;
	}


	public PatientCalendarPlan getCalendarPlans(int vacctinationId) {
		return calendarPlans.get(vacctinationId);
	}
	public PatientVacctination getPatientVacctination(int vacctinationId) {
		return vacctinations.get(vacctinationId);
	}
	public PatientVacctinationResult getPatientVacctinationResult(int patientVacctinationId) {
		return results.get(patientVacctinationId);
	}
	public PatientVacctinationRenouncement getPatientVacctinationRenouncement(int vacctinationId) {
		return renouncements.get(vacctinationId);
	}
	public List<PatientVacctinationFault> getPatientVacctinationFaults(int vacctinationId) {
		return faults.get(vacctinationId);
	}
}