/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author testtest
 */
@Entity
@Table(name = "medemployee_institution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedemployeeInstitution.findAll", query = "SELECT m FROM MedemployeeInstitution m")})
public class MedemployeeInstitution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedEmployeeInstitution")
    private Integer idMedEmployeeInstitution;
    @Basic(optional = false)
    @Column(name = "idInstitution")
    private int idInstitution;
    @Basic(optional = false)
    @Column(name = "idMedEmployee")
    private int idMedEmployee;

    public MedemployeeInstitution() {
    }

    public MedemployeeInstitution(Integer idMedEmployeeInstitution) {
	this.idMedEmployeeInstitution = idMedEmployeeInstitution;
    }

    public MedemployeeInstitution(Integer idMedEmployeeInstitution, int idInstitution, int idMedEmployee) {
	this.idMedEmployeeInstitution = idMedEmployeeInstitution;
	this.idInstitution = idInstitution;
	this.idMedEmployee = idMedEmployee;
    }

    public Integer getIdMedEmployeeInstitution() {
	return idMedEmployeeInstitution;
    }

    public void setIdMedEmployeeInstitution(Integer idMedEmployeeInstitution) {
	this.idMedEmployeeInstitution = idMedEmployeeInstitution;
    }

    public int getIdInstitution() {
	return idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
	this.idInstitution = idInstitution;
    }

    public int getIdMedEmployee() {
	return idMedEmployee;
    }

    public void setIdMedEmployee(int idMedEmployee) {
	this.idMedEmployee = idMedEmployee;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idMedEmployeeInstitution != null ? idMedEmployeeInstitution.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof MedemployeeInstitution)) {
	    return false;
	}
	MedemployeeInstitution other = (MedemployeeInstitution) object;
	if ((this.idMedEmployeeInstitution == null && other.idMedEmployeeInstitution != null) || (this.idMedEmployeeInstitution != null && !this.idMedEmployeeInstitution.equals(other.idMedEmployeeInstitution))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.MedemployeeInstitution[ idMedEmployeeInstitution=" + idMedEmployeeInstitution + " ]";
    }
    
}
