/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.PatientDAO;
import ua.nure.gavr.model.Patient;
import ua.nure.gavr.model.PatientInstitution;

/**
 * @author gavr
 *
 */
@Component
public class PatientDAOImpl extends AbstractDAO implements PatientDAO {

	@Override
	public Patient findPatient(Integer patientId) {
		Patient patient = (Patient) getSession().load(Patient.class, patientId);
		Hibernate.initialize(patient);
		return patient;
	}

	@Override
	public List<Patient> findPatients(Integer idInstitution, Integer year) {
		DetachedCriteria subCriteria = DetachedCriteria
				.forClass(PatientInstitution.class)
				.add(Restrictions.eq("idInstitution", idInstitution))
				.setProjection(Projections.property("idPatient"));
		Criteria criteria = getSession()
				.createCriteria(Patient.class)
				.add(Subqueries.propertyIn("idPatient", subCriteria));
		if(year != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.DATE, 1);
			calendar.set(Calendar.MONTH, Calendar.JANUARY);
			calendar.set(Calendar.YEAR, year);
			criteria.add(Restrictions.gt("birthday", calendar.getTime()));
			calendar.add(Calendar.YEAR, 1);
			criteria.add(Restrictions.lt("birthday", calendar.getTime()));
		}
		@SuppressWarnings("unchecked")
		List<Patient> retList = criteria.list();
		return retList;
	}

	@Override
	public List<Integer> findPatientBirthYear() {
		Criteria criteria = getSession().createCriteria(Patient.class)
				.setProjection(Projections.property("birthday"));
		@SuppressWarnings("unchecked")
		List<Date> yearList = criteria.list();
		Set<Integer> tmpSet = new HashSet<Integer>();
		for (Date birthday : yearList) {
			DateTime dateTime = new DateTime(birthday.getTime());
			tmpSet.add(dateTime.getYear());
		}
		ArrayList<Integer> list = new ArrayList<Integer>(tmpSet);
		Collections.sort(list);
		return list;
	}

	@Override
	public List<Patient> findPatients(Integer idInstitution) {
		DetachedCriteria subCriteria = DetachedCriteria
				.forClass(PatientInstitution.class)
				.add(Restrictions.eq("idInstitution", idInstitution))
				.setProjection(Projections.property("idPatient"));
		@SuppressWarnings("unchecked")
		List<Patient> retList = getSession()
				.createCriteria(Patient.class)
				.add(Subqueries.propertyIn("idPatient", subCriteria)).list();

		return retList;
	}

}
