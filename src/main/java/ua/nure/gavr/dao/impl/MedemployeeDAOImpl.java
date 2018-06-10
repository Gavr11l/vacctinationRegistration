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

import ua.nure.gavr.dao.MedemployeeDAO;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.model.MedemployeeSystemUser;

/**
 * @author gavr
 *
 */
@Component
public class MedemployeeDAOImpl extends AbstractDAO implements MedemployeeDAO {

	@Override
	public Medemployee findMedEmployee(Integer idSystemUser) {
		DetachedCriteria subquery = DetachedCriteria
				.forClass(MedemployeeSystemUser.class);
		// subquery.createAlias("groupMembers", "gm");
		subquery.add(Restrictions.eq("idSystemUser", idSystemUser));
		subquery.setProjection(Projections.property("idMedEmployee"));

		@SuppressWarnings("unchecked")
		List<Medemployee> retlist = getSession()
				.createCriteria(Medemployee.class)
				.add(Subqueries.propertyIn("idMedEmployee", subquery)).list();

		return !retlist.isEmpty() ? retlist.get(0) : null;
	}

}
