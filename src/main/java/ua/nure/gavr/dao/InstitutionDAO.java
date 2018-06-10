/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.model.Institution;

/**
 * @author gavr
 *
 */
public interface InstitutionDAO {

	public List<Institution> findInstitution(Integer idMedEmployee);

}
