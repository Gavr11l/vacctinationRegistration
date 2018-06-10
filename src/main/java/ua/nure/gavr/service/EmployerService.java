/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.service;

import java.util.List;

import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.model.SystemUser;

/**
 *
 * @author gavr
 */
public interface EmployerService {

	List<Institution> findInstitution(Integer idMedEmployee);

	Medemployee findMedEmployee(Integer idSystemUser);

	SystemUser findUser(String loginName, String password);

}
