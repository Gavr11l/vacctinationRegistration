/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.PatientVacctinationResultDAO;
import ua.nure.gavr.model.PatientVacctination;
import ua.nure.gavr.model.PatientVacctinationResult;

/**
 * @author gavr
 *
 */
@Component
public class PatientVacctinationResultDAOImpl extends AbstractDAO implements PatientVacctinationResultDAO {

	@Override
	public PatientVacctinationResult findPatientVacctinationResult(
			Integer paatientVacctinationId) {
		@SuppressWarnings("unchecked")
		List<PatientVacctinationResult> retList = getSession()
				.createCriteria(PatientVacctinationResult.class)
				.add(Restrictions.eq("idPatientVacctination",paatientVacctinationId))
				.list();
		return !retList.isEmpty() ? retList.get(0) : null;
	}

	@Override
	public void savePatientVacctinationResult(PatientVacctinationResult patientVacctinationResult) {
		getSession().save(patientVacctinationResult);
	}

	@Override
	public void updatePatientVacctinationResult(PatientVacctinationResult patientVacctinationResult) {
		getSession().update(patientVacctinationResult);
	}

	@Override
	public List<PatientVacctinationResult> findResults(Integer patientId) {
		DetachedCriteria subquery = DetachedCriteria.forClass(PatientVacctination.class)
				.add(Restrictions.eq("idPatient", patientId))
				.setProjection(Projections.property("idPatientVacctination"));

		@SuppressWarnings("unchecked")
		List<PatientVacctinationResult> retList = getSession()
				.createCriteria(PatientVacctinationResult.class)
				.add(Subqueries.propertyIn("idPatientVacctination", subquery))
				.list();
		return retList;
	}

}
