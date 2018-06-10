/**
 *
 */
package ua.nure.gavr.dao;

import java.util.List;

import ua.nure.gavr.model.Vacctination;

/**
 * @author gavr
 *
 */
public interface VacctinationDAO {

	public Vacctination findVacctination(Integer vacctinationId);

	public List<Vacctination> findVaccinations();

}
