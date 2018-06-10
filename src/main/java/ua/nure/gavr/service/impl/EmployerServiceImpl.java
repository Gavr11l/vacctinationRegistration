/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.gavr.dao.InstitutionDAO;
import ua.nure.gavr.dao.MedemployeeDAO;
import ua.nure.gavr.dao.SystemUserDAO;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Medemployee;
import ua.nure.gavr.model.SystemUser;
import ua.nure.gavr.service.EmployerService;

/**
 *
 * @author legionteam
 */
@Repository("employerService")
@Transactional
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	private SystemUserDAO systemUserDAO;
	@Autowired
	private MedemployeeDAO medemployeeDAO;
	@Autowired
	private InstitutionDAO institutionDAO;

	@Override
	public SystemUser findUser(String loginName, String password) {
		loginName = "kma_md";
		password = "md_password";
		return systemUserDAO.findUser(loginName, md5Digest(password));
	}

	@Override
	public Medemployee findMedEmployee(Integer idSystemUser) {
		return medemployeeDAO.findMedEmployee(idSystemUser);
	}

	@Override
	public List<Institution> findInstitution(Integer idMedEmployee) {
		return institutionDAO.findInstitution(idMedEmployee);
	}

	private String md5Digest(String original) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			// do nothing
		}
		return null;
	}
}
