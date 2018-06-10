/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.VacctinationFullNameDAO;
import ua.nure.gavr.model.VacctinationFullName;

/**
 * @author gavr
 *
 */
@Component
public class VacctinationFullNameDAOImpl extends AbstractDAO implements VacctinationFullNameDAO {
	@Override
	public VacctinationFullName findVacctinaionFullName(Integer vaacctinationId) {
		@SuppressWarnings("unchecked")
		List<VacctinationFullName> retList = getSession()
				.createCriteria(VacctinationFullName.class)
				.add(Restrictions.eq("idVacctination", vaacctinationId)).list();
		return !retList.isEmpty() ? retList.get(0) : null;
	}


}
