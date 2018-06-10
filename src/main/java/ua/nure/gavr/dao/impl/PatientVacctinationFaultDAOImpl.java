/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.PatientVacctinationFaultDAO;
import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientVacctinationFault;

/**
 * @author gavr
 *
 */
@Component
public class PatientVacctinationFaultDAOImpl extends AbstractDAO implements PatientVacctinationFaultDAO {

	@Override
	public void savePatientVacctinationFaultResult(
			PatientVacctinationFault patientVacctinationFault) {
		getSession().save(patientVacctinationFault);
	}

	@Override
	public List<PatientVacctinationFault> findFaultVacctination(Integer institutionId,
			DateType dateType, List<Integer> vacctinationIds) {
		Criteria criteria = createBasicVacctinationCriteria(
				PatientVacctinationFault.class, "vacctinationFaultDate",
				institutionId, dateType, vacctinationIds);
		@SuppressWarnings("unchecked")
		List<PatientVacctinationFault> dataList = criteria.list();
		return dataList;
	}

	@Override
	public PatientVacctinationFault findPatientVacctinationFault(Integer patientId, Integer vacctinationId) {
		@SuppressWarnings("unchecked")
		List<PatientVacctinationFault> retList = getSession()
				.createCriteria(PatientVacctinationFault.class)
				.add(Restrictions.eq("idPatient", patientId))
				.add(Restrictions.eq("idVacctination", vacctinationId)).list();
		return !retList.isEmpty() ? retList.get(0) : null;
	}

	@Override
	public List<PatientVacctinationFault> findFaults(Integer patientId) {
		@SuppressWarnings("unchecked")
		List<PatientVacctinationFault> retList = getSession()
				.createCriteria(PatientVacctinationFault.class)
				.add(Restrictions.eq("idPatient", patientId))
				.list();
		return retList;
	}

}
