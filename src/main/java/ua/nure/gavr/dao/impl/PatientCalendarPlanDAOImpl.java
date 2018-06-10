/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.PatientCalendarPlanDAO;
import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientCalendarPlan;

/**
 * @author gavr
 *
 */
@Component
public class PatientCalendarPlanDAOImpl extends AbstractDAO implements PatientCalendarPlanDAO {
	@Override
	public PatientCalendarPlan findPatientCalendarPlan(
			Integer patientCalendarPlanId) {
		PatientCalendarPlan patientCalendarPlan = (PatientCalendarPlan) getSession().load(
				PatientCalendarPlan.class, patientCalendarPlanId);
		Hibernate.initialize(patientCalendarPlan);
		return patientCalendarPlan;
	}

	@Override
	public List<PatientCalendarPlan> findPlannedVacctinationsCP(
			Integer idInstitution, List<Integer> vacctinationIds, Integer year) {
		DetachedCriteria subquery = createInstitutionPatientSubCriteria(idInstitution);


		Criteria criteria = getSession().createCriteria(PatientCalendarPlan.class)
				.add(Subqueries.propertyIn("idPatient", subquery));
		if(year!= null) {
			DetachedCriteria subquery2 = DetachedCriteria
					.forClass(Patient.class);
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.DATE, 1);
			calendar.set(Calendar.MONTH, Calendar.JANUARY);
			calendar.set(Calendar.YEAR, year);
			subquery2.add(Restrictions.gt("birthday", calendar.getTime()));
			calendar.add(Calendar.YEAR, 1);
			subquery2.add(Restrictions.lt("birthday", calendar.getTime()));

			subquery2.setProjection(Projections.property("idPatient"));
			criteria.add(Subqueries.propertyIn("idPatient", subquery2));
		}
		if (vacctinationIds.size() > 0)
			criteria.add(Restrictions.in("idVacctination", vacctinationIds));
		@SuppressWarnings("unchecked")
		List<PatientCalendarPlan> retList = criteria.list();
		return retList;
	}

	@Override
	public List<PatientCalendarPlan> findPlannedVacctinations(Integer institutionId, DateType dateType,
			List<Integer> vacctinationIds) {
		Criteria criteria = createBasicVacctinationCriteria(PatientCalendarPlan.class,
				institutionId, dateType,vacctinationIds);
		@SuppressWarnings("unchecked")
		List<PatientCalendarPlan> dataList = criteria.list();
		return dataList;
	}

	@Override
	public List<PatientCalendarPlan> findPlannedVacctinationsWithoutFaultAndRenouncement(
			Integer institutionId, DateType dateType, List<Integer> vactinationIds) {
		Criteria criteria = createBasicVacctinationCriteria(
				PatientCalendarPlan.class, institutionId, dateType,
				vactinationIds);
		@SuppressWarnings("unchecked")
		List<PatientCalendarPlan> retList = criteria.list();
		return retList;
	}

	@Override
	public PatientCalendarPlan findPatientCalendarPlan(Integer patientId, Integer vacctinationId) {
		PatientCalendarPlan patientCalendarPlan;
		@SuppressWarnings("unchecked")
		List<PatientCalendarPlan> retList = getSession()
				.createCriteria(PatientCalendarPlan.class)
				.add(Restrictions.eq("idPatient", patientId))
				.add(Restrictions.eq("idVacctination", vacctinationId)).list();
		patientCalendarPlan = !retList.isEmpty() ? retList.get(0) : null;

		return patientCalendarPlan;
	}

	@Override
	public void updatePatientCalendarPlan(PatientCalendarPlan patientCalendarPlan) {
		getSession().update(patientCalendarPlan);
	}

	@Override
	public void savePatientCalendarPlan(PatientCalendarPlan patientCalendarPlan) {
		getSession().save(patientCalendarPlan);
	}

	@Override
	public List<PatientCalendarPlan> findPatientCalendarPlans(Integer patientId) {
		@SuppressWarnings("unchecked")
		List<PatientCalendarPlan> retList = getSession()
				.createCriteria(PatientCalendarPlan.class)
				.add(Restrictions.eq("idPatient", patientId)).list();
		return retList;
	}

}
