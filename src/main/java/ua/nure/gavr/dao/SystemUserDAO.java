/**
 *
 */
package ua.nure.gavr.dao;

import ua.nure.gavr.model.SystemUser;

/**
 * @author gavr
 *
 */
public interface SystemUserDAO {
	public SystemUser findUser(String loginName, String password);

}
