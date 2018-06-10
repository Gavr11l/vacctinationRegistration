/**
 *
 */
package ua.nure.gavr.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import ua.nure.gavr.dao.SystemUserDAO;
import ua.nure.gavr.model.SystemUser;

/**
 * @author gavr
 *
 */
@Component
public class SystemUserDAOImpl extends AbstractDAO implements SystemUserDAO {


	@Override
	public SystemUser findUser(String loginName, String password) {
		@SuppressWarnings("unchecked")
		List<SystemUser> retlist = getSession()
				.createCriteria(SystemUser.class)
				.add(Restrictions.eq("login", loginName))
				.add(Restrictions.eq("password", password)).list();
		return !retlist.isEmpty() ? retlist.get(0) : null;
	}


}
