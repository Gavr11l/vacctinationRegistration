/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.PatientInstitution;
import ua.nure.gavr.util.DateMargin;
import ua.nure.gavr.util.NamesHelper;

/**
 * @author gavr
 *
 */
public class AbstractDAO {
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Criteria createBasicVacctinationCriteria(Class<?> clazz,
			Integer idInstitution, DateType dateType,
			List<Integer> idsVactination) {
		return createBasicVacctinationCriteria(clazz, "vacctinationDate",
				idInstitution, dateType, idsVactination);
	}

	protected Criteria createBasicVacctinationCriteria(Class<?> clazz,
			String dateFieldName, Integer idInstitution, DateType dateType,
			List<Integer> idsVactination) {
		DetachedCriteria subquery = createInstitutionPatientSubCriteria(idInstitution);
		DateMargin dateMargin = NamesHelper.getDateMargin(dateType);

		Criteria criteria = getSession().createCriteria(clazz)
				.add(Restrictions.ge(dateFieldName, dateMargin.getStartDate()))
				.add(Restrictions.lt(dateFieldName, dateMargin.getEndDate()))
				.add(Subqueries.propertyIn("idPatient", subquery));
		if (idsVactination.size() > 0)
			criteria.add(Restrictions.in("idVacctination", idsVactination));
		return criteria;
	}

	protected DetachedCriteria createInstitutionPatientSubCriteria(Integer idInstitution) {
		DetachedCriteria subquery = DetachedCriteria.forClass(PatientInstitution.class);
		subquery.add(Restrictions.eq("idInstitution", idInstitution));
		subquery.setProjection(Projections.property("idPatient"));
		return subquery;
	}


}
