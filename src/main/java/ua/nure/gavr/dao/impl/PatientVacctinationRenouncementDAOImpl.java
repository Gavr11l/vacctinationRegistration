/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.PatientVacctinationRenouncementDAO;
import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientVacctinationRenouncement;

/**
 * @author gavr
 *
 */
@Component
public class PatientVacctinationRenouncementDAOImpl extends AbstractDAO implements PatientVacctinationRenouncementDAO {
	@Override
	public PatientVacctinationRenouncement findPatientVacctinationRenouncement(
			Integer patientId, Integer vacctinationId) {
		@SuppressWarnings("unchecked")
		List<PatientVacctinationRenouncement> retList = getSession()
				.createCriteria(PatientVacctinationRenouncement.class)
				.add(Restrictions.eq("idVacctination", vacctinationId))
				.add(Restrictions.eq("idPatient", patientId)).list();
		return !retList.isEmpty() ? retList.get(0) : null;
	}

	@Override
	public List<PatientVacctinationRenouncement> findRecouncementVacctination(
			Integer institutionId, DateType dateType,List<Integer> vactinationIds) {
		Criteria criteria = createBasicVacctinationCriteria(
				PatientVacctinationRenouncement.class, "renouncementDate",
				institutionId, dateType, vactinationIds);

		@SuppressWarnings("unchecked")
		List<PatientVacctinationRenouncement> dataList = criteria.list();
		return dataList;
	}

	@Override
	public void savePatientVacctinationRenouncement(PatientVacctinationRenouncement renouncement) {
		getSession().save(renouncement);
	}

	@Override
	public List<PatientVacctinationRenouncement> findRenouncements(
			Integer patientId) {
		@SuppressWarnings("unchecked")
		List<PatientVacctinationRenouncement> retList = getSession()
				.createCriteria(PatientVacctinationRenouncement.class)
				.add(Restrictions.eq("idPatient", patientId)).list();
		return retList;
	}

}
