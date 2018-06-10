/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.VacctinationDAO;
import ua.nure.gavr.model.Vacctination;

/**
 * @author gavr
 *
 */
@Component
public class VacctinationDAOImpl extends AbstractDAO implements VacctinationDAO {

	@Override
	public List<Vacctination> findVaccinations() {
		Criteria criteria = getSession().createCriteria(Vacctination.class);
		@SuppressWarnings("unchecked")
		List<Vacctination> retList = criteria.list();
		return retList;
	}

	@Override
	public Vacctination findVacctination(Integer idVacctination) {
		Vacctination vacctination = (Vacctination) getSession().load(
				Vacctination.class, idVacctination);
		Hibernate.initialize(vacctination);
		return vacctination;
	}

}
