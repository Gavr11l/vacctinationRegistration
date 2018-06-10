/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.gavr.dao.PatientCalendarPlanDAO;
import ua.nure.gavr.dao.PatientDAO;
import ua.nure.gavr.dao.PatientParentDAO;
import ua.nure.gavr.dao.PatientVacctinationDAO;
import ua.nure.gavr.dao.PatientVacctinationFaultDAO;
import ua.nure.gavr.dao.PatientVacctinationRenouncementDAO;
import ua.nure.gavr.dao.PatientVacctinationResultDAO;
import ua.nure.gavr.dao.VacctinationDAO;
import ua.nure.gavr.dao.VacctinationFullNameDAO;
import ua.nure.gavr.data.CalendarPlanWrapper;
import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.FaultWrapper;
import ua.nure.gavr.data.RenouncementWrapper;
import ua.nure.gavr.data.VacctinationWrapper;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationFault;
import ua.nure.gavr.model.PatientVacctinationRenouncement;
import ua.nure.gavr.model.PatientVacctinationResult;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.model.VacctinationFullName;
import ua.nure.gavr.service.VacctinationService;

/**
 *
 * @author testtest
 */
@Repository("vacctinationService")
@Transactional
public class VacctinationServiceImpl implements VacctinationService {
	@Autowired
	private PatientCalendarPlanDAO patientCalendarPlanDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private PatientVacctinationDAO patientVacctinationDAO;
	@Autowired
	private VacctinationDAO vacctinationDAO;
	@Autowired
	private VacctinationFullNameDAO vacctinationFullNameDAO;
	@Autowired
	private PatientParentDAO patientParentDAO;
	@Autowired
	private PatientVacctinationRenouncementDAO patientVacctinationRenouncementDAO;
	@Autowired
	private PatientVacctinationFaultDAO patientVacctinationFaultDAO;
	@Autowired
	private PatientVacctinationResultDAO patientVacctinationResultDAO;

	@Override
	public List<VacctinationWrapper> findVacctination(Integer idInstitution,
			DateType dateType, List<Integer> idsVactination) {
		List<VacctinationWrapper> retList = new ArrayList<>();
		List<PatientVacctination> dataList = patientVacctinationDAO.findVacctination(idInstitution, dateType, idsVactination);
		for (Iterator<PatientVacctination> iterator = dataList.iterator(); iterator.hasNext();) {
			PatientVacctination patientVacctination = iterator.next();

			int idPatient = patientVacctination.getIdPatient();
			int idVacctination = patientVacctination.getIdVacctination();
			Integer idPatientVacctination = patientVacctination.getIdPatientVacctination();
			VacctinationWrapper wrapper = new VacctinationWrapper();
			wrapper.setPatientVacctinaion(patientVacctination);
			wrapper.setPatient(patientDAO.findPatient(idPatient));
			wrapper.setVacctination(vacctinationDAO.findVacctination(idVacctination));
			wrapper.setVacctinaionFullName(vacctinationFullNameDAO.findVacctinaionFullName(idVacctination));
			wrapper.setPatientVacctinationResult(patientVacctinationResultDAO.findPatientVacctinationResult(idPatientVacctination));
			retList.add(wrapper);

		}

		return retList;
	}

	@Override
	public List<FaultWrapper> findFaultVacctination(Integer idInstitution,
			DateType dateType, List<Integer> idsVactination) {
		List<FaultWrapper> retList = new ArrayList<>();
		List<PatientVacctinationFault> dataList = patientVacctinationFaultDAO.findFaultVacctination(idInstitution, dateType, idsVactination);
		for (PatientVacctinationFault patientVaccFault : dataList) {
			int idPatient = patientVaccFault.getIdPatient();
			int idVacctination = patientVaccFault.getIdVacctination();
			FaultWrapper wrapper = new FaultWrapper();
			wrapper.setPatientVacctinationFault(patientVaccFault);
			wrapper.setPatient(patientDAO.findPatient(idPatient));
			wrapper.setVacctination(vacctinationDAO.findVacctination(idVacctination));
			wrapper.setVacctinaionFullName(vacctinationFullNameDAO.findVacctinaionFullName(idVacctination));
			retList.add(wrapper);
		}

		return retList;
	}

	@Override
	public List<RenouncementWrapper> findRecouncementVacctination(
			Integer idInstitution, DateType dateType, List<Integer> idsVactination) {
		List<RenouncementWrapper> retList = new ArrayList<>();
		List<PatientVacctinationRenouncement> dataList = patientVacctinationRenouncementDAO
				.findRecouncementVacctination(idInstitution, dateType, idsVactination);
		for (PatientVacctinationRenouncement patientVaccRenouncement : dataList) {
			int idPatient = patientVaccRenouncement.getIdPatient();
			int idVacctination = patientVaccRenouncement.getIdVacctination();
			int idPatientParent = patientVaccRenouncement.getIdPatientParent();

			RenouncementWrapper wrapper = new RenouncementWrapper();
			wrapper.setPatientVacctinationRenouncement(patientVaccRenouncement);
			wrapper.setPatient(patientDAO.findPatient(idPatient));
			wrapper.setVacctination(vacctinationDAO.findVacctination(idVacctination));
			wrapper.setVacctinaionFullName(vacctinationFullNameDAO.findVacctinaionFullName(idVacctination));
			wrapper.setPatientParent(patientParentDAO.findPatientParent(idPatientParent));
			retList.add(wrapper);
		}
		return retList;
	}

	@Override
	public List<CalendarPlanWrapper> findPlannedVacctinations(Integer idInstitution, DateType dateType,
			List<Integer> idsVactination) {
		List<CalendarPlanWrapper> retList = new ArrayList<>();
		List<PatientCalendarPlan> dataList = patientCalendarPlanDAO.findPlannedVacctinations(idInstitution, dateType, idsVactination);
		for (PatientCalendarPlan patientCalendarPlan : dataList) {
			int idPatient = patientCalendarPlan.getIdPatient();
			int idVacctination = patientCalendarPlan.getIdVacctination();
			PatientVacctination existVaccination = patientVacctinationDAO.findPatientVaccination(
					idPatient,idVacctination);
			if (existVaccination == null) {
				CalendarPlanWrapper wrapper = new CalendarPlanWrapper();
				wrapper.setPatientCalendarPlan(patientCalendarPlan);
				wrapper.setPatient(patientDAO.findPatient(idPatient));
				wrapper.setVacctination(vacctinationDAO.findVacctination(idVacctination));
				wrapper.setVacctinaionFullName(vacctinationFullNameDAO.findVacctinaionFullName(idVacctination));
				wrapper.setPatientParentList(patientParentDAO.findParentList(idPatient));
				retList.add(wrapper);
			}
		}
		return retList;
	}


	@Override
	public List<Vacctination> findVaccinations() {
		return vacctinationDAO.findVaccinations();
	}

	@Override
	public void savePatientVacctinationResult(PatientVacctinationResult patientVacctinationResult) {
		patientVacctinationResultDAO.savePatientVacctinationResult(patientVacctinationResult);
	}

	@Override
	public void updatePatientVacctinationResult(PatientVacctinationResult patientVacctinationResult) {
		patientVacctinationResultDAO.updatePatientVacctinationResult(patientVacctinationResult);
	}

	@Override
	public List<CalendarPlanWrapper> findPlannedVacctinationsWithoutFaultAndRenouncement(
			Integer idInstitution, DateType dateType, List<Integer> idsVactination) {
		List<CalendarPlanWrapper> retList = new ArrayList<>();

		List<PatientCalendarPlan> dataList = patientCalendarPlanDAO
				.findPlannedVacctinationsWithoutFaultAndRenouncement(idInstitution, dateType, idsVactination);
		for (PatientCalendarPlan patientCalendarPlan : dataList) {
			int patientId = patientCalendarPlan.getIdPatient();
			int vacctinationId = patientCalendarPlan.getIdVacctination();
			PatientVacctination existVaccination = patientVacctinationDAO.findPatientVaccination(patientId, vacctinationId);
			PatientVacctinationFault patientVacctinationFault = patientVacctinationFaultDAO
					.findPatientVacctinationFault(patientId, vacctinationId);
			PatientVacctinationRenouncement patientVacctinationRenouncement = patientVacctinationRenouncementDAO
					.findPatientVacctinationRenouncement(patientId, vacctinationId);
			if (existVaccination == null && patientVacctinationFault == null && patientVacctinationRenouncement == null) {
				CalendarPlanWrapper wrapper = new CalendarPlanWrapper();
				wrapper.setPatientCalendarPlan(patientCalendarPlan);
				wrapper.setPatient(patientDAO.findPatient(patientId));
				wrapper.setVacctination(vacctinationDAO.findVacctination(vacctinationId));
				wrapper.setVacctinaionFullName(vacctinationFullNameDAO.findVacctinaionFullName(vacctinationId));
				wrapper.setPatientParentList(patientParentDAO.findParentList(patientId));
				retList.add(wrapper);
			}
		}
		return retList;
	}

	@Override
	public void savePatientVacctinationRenouncement(PatientVacctinationRenouncement renouncement) {
		patientVacctinationRenouncementDAO.savePatientVacctinationRenouncement(renouncement);
	}

	@Override
	public void savePatientVacctinationFaultResult(PatientVacctinationFault patientVacctinationFault) {
		patientVacctinationFaultDAO.savePatientVacctinationFaultResult(patientVacctinationFault);
	}

	@Override
	public void savePatientVacctinationData(
			PatientVacctination patientVacctination) {
		patientVacctinationDAO.savePatientVacctinationData(patientVacctination);
	}

	@Override
	public PatientVacctination findPatienVacctination(Integer idPatient,
			Integer idVacctination) {
		return patientVacctinationDAO.findPatientVaccination(idPatient, idVacctination);
	}

	@Override
	public void updatePatienVacctination(PatientVacctination patientVacctination) {
		patientVacctinationDAO.updatePatienVacctination(patientVacctination);
	}

	@Override
	public PatientCalendarPlan findPatientCalendarPlan(Integer patientId,
			Integer vacctinationId) {
		return patientCalendarPlanDAO.findPatientCalendarPlan(patientId, vacctinationId);
	}


	@Override
	public List<Patient> findPatients(Integer idInstitution) {
		return patientDAO.findPatients(idInstitution);
	}

	@Override
	public void updatePatientCalendarPlan(PatientCalendarPlan patientCalendarPlan) {
		patientCalendarPlanDAO.updatePatientCalendarPlan(patientCalendarPlan);
	}

	@Override
	public void savePatientCalendarPlan(PatientCalendarPlan patientCalendarPlan) {
		patientCalendarPlanDAO.savePatientCalendarPlan(patientCalendarPlan);
	}

	@Override
	public Patient findPatient(Integer patientId) {
		return patientDAO.findPatient(patientId);
	}

	@Override
	public Vacctination findVacctination(Integer vacctinationId) {
		return vacctinationDAO.findVacctination(vacctinationId);
	}

	@Override
	public VacctinationFullName findVacctinationFullName(Integer vacctinationId) {
		return vacctinationFullNameDAO.findVacctinaionFullName(vacctinationId);
	}

	@Override
	public PatientVacctinationRenouncement findPatientVacctinationRenouncement(
			Integer patientId, Integer vacctinationId) {
		return patientVacctinationRenouncementDAO.findPatientVacctinationRenouncement(patientId, vacctinationId) ;
	}

	@Override
	public List<PatientParent> findPatientParents(Integer patientId) {
		return patientParentDAO.findParentList(patientId);
	}

	@Override
	public List<Integer> findYear() {
		return patientDAO.findPatientBirthYear();
	}

	@Override
	public List<CalendarPlanWrapper> findPlannedVacctinationsCP(
			Integer idInstitution, List<Integer> vacctinationIds, Integer year) {
		List<CalendarPlanWrapper> retList = new ArrayList<>();

		List<PatientCalendarPlan> dataList = patientCalendarPlanDAO
				.findPlannedVacctinationsCP(idInstitution, vacctinationIds,year);
		for (PatientCalendarPlan patientCalendarPlan : dataList) {
			int idPatient = patientCalendarPlan.getIdPatient();
			int idVacctination = patientCalendarPlan.getIdVacctination();

			PatientVacctination existVaccination = patientVacctinationDAO.findPatientVaccination(
					idPatient, idVacctination);

			if (existVaccination == null) {
				CalendarPlanWrapper wrapper = new CalendarPlanWrapper();
				wrapper.setPatientCalendarPlan(patientCalendarPlan);
				wrapper.setPatient(patientDAO.findPatient(idPatient));
				wrapper.setVacctination(vacctinationDAO.findVacctination(idVacctination));
				wrapper.setVacctinaionFullName(vacctinationFullNameDAO.findVacctinaionFullName(idVacctination));
				wrapper.setPatientParentList(patientParentDAO.findParentList(idPatient));
				retList.add(wrapper);
			}
		}
		return retList;
	}

	@Override
	public List<Patient> findPatients(Integer idInstitution, Integer year) {
		return patientDAO.findPatients(idInstitution, year);

	}

	@Override
	public PatientCalendarPlan findPatientCalendarPlan(
			Integer patientCalendarPlanId) {
		return patientCalendarPlanDAO
				.findPatientCalendarPlan(patientCalendarPlanId);
	}

	@Override
	public PatientVacctinationResult findPatientVacctinationResult(Integer patientVacctinationId) {
		return patientVacctinationResultDAO.findPatientVacctinationResult(patientVacctinationId);
	}

	@Override
	public PatientVacctinationFault findPatientVacctinationFault(
			Integer patientId, Integer vacctinationId) {
		return patientVacctinationFaultDAO.findPatientVacctinationFault(patientId, vacctinationId);
	}

	@Override
	public List<PatientCalendarPlan> getPatientCalendarPlans(Integer patientId) {
		return patientCalendarPlanDAO.findPatientCalendarPlans(patientId);
	}

	@Override
	public List<PatientVacctinationFault> getFaults(Integer patientId) {
		return patientVacctinationFaultDAO.findFaults(patientId);
	}

	@Override
	public List<PatientVacctinationRenouncement> getRenouncements(
			Integer patientId) {
		return patientVacctinationRenouncementDAO.findRenouncements(patientId);
	}

	@Override
	public List<PatientVacctinationResult> getResults(Integer patientId) {
		return patientVacctinationResultDAO.findResults(patientId);
	}

	@Override
	public List<PatientVacctination> findVaccinationss(Integer patientId) {
		return patientVacctinationDAO.findVaccinationss(patientId);
	}

	@Override
	public PatientParent findPatientParent(Integer patientParentId) {
		return patientParentDAO.findPatientParent(patientParentId);
	}

}
