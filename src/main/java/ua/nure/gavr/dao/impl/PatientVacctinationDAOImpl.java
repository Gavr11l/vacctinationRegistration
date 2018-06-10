/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.PatientVacctinationDAO;
import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientVacctination;

/**
 * @author gavr
 *
 */
@Component
public class PatientVacctinationDAOImpl extends AbstractDAO implements
		PatientVacctinationDAO {

	@Override
	public PatientVacctination findPatientVaccination(Integer patientId,Integer vacctinationId) {
		@SuppressWarnings("unchecked")
		List<PatientVacctination> retList = getSession()
				.createCriteria(PatientVacctination.class)
				.add(Restrictions.eq("idPatient", patientId))
				.add(Restrictions.eq("idVacctination", vacctinationId)).list();
		return !retList.isEmpty() ? retList.get(0) : null;
	}

	@Override
	public List<PatientVacctination> findVacctination(Integer institutionId,
			DateType dateType, List<Integer> vacctinationIds) {
		Criteria criteria = createBasicVacctinationCriteria(
				PatientVacctination.class, institutionId, dateType,
				vacctinationIds);
		@SuppressWarnings("unchecked")
		List<PatientVacctination> retList = criteria.list();
		return retList;
	}

	@Override
	public void savePatientVacctinationData(PatientVacctination patientVacctination) {
		getSession().save(patientVacctination);
	}

	@Override
	public void updatePatienVacctination(PatientVacctination patientVacctination) {
		getSession().update(patientVacctination);
	}

	@Override
	public List<PatientVacctination> findVaccinationss(Integer patientId) {
		@SuppressWarnings("unchecked")
		List<PatientVacctination> retList = getSession()
				.createCriteria(PatientVacctination.class)
				.add(Restrictions.eq("idPatient", patientId))
				.list();
		return retList;
	}
}
