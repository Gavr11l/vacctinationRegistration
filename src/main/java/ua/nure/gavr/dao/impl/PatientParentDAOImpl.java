/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.PatientParentDAO;
import ua.nure.gavr.model.PatientParent;
import ua.nure.gavr.model.PatientParentPatient;

/**
 * @author gavr
 *
 */
@Component
public class PatientParentDAOImpl extends AbstractDAO implements PatientParentDAO {
	@Override
	public List<PatientParent> findParentList(Integer patientId) {
		DetachedCriteria subquery = DetachedCriteria.forClass(PatientParentPatient.class)
				.add(Restrictions.eq("idPatient", patientId))
				.setProjection(Projections.property("idPatientParent"));

		Criteria criteria = getSession().createCriteria(PatientParent.class)
				.add(Subqueries.propertyIn("idPatientParent", subquery));

		@SuppressWarnings("unchecked")
		List<PatientParent> retList = criteria.list();
		return retList;
	}

	@Override
	public PatientParent findPatientParent(Integer patientParentId) {
		PatientParent patientParent = (PatientParent) getSession().load(
				PatientParent.class, patientParentId);
		Hibernate.initialize(patientParent);
		return patientParent;
	}


}
