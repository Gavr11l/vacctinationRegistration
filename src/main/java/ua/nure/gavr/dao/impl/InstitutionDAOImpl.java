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

import ua.nure.gavr.dao.InstitutionDAO;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.MedemployeeInstitution;

/**
 * @author gavr
 *
 */
@Component
public class InstitutionDAOImpl extends AbstractDAO implements InstitutionDAO {

	@Override
	public List<Institution> findInstitution(Integer idMedEmployee) {
		DetachedCriteria subquery = DetachedCriteria
				.forClass(MedemployeeInstitution.class);
		// subquery.createAlias("groupMembers", "gm");
		subquery.add(Restrictions.eq("idMedEmployee", idMedEmployee));
		subquery.setProjection(Projections.property("idInstitution"));

		@SuppressWarnings("unchecked")
		List<Institution> retlist = getSession()
				.createCriteria(Institution.class)
				.add(Subqueries.propertyIn("idInstitution", subquery)).list();

		return retlist;
	}

}
