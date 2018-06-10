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
@Table(name = "patient_institution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientInstitution.findAll", query = "SELECT p FROM PatientInstitution p")})
public class PatientInstitution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatientInstitution")
    private Integer idPatientInstitution;
    @Basic(optional = false)
    @Column(name = "idPatient")
    private int idPatient;
    @Basic(optional = false)
    @Column(name = "idInstitution")
    private int idInstitution;

    public PatientInstitution() {
    }

    public PatientInstitution(Integer idPatientInstitution) {
	this.idPatientInstitution = idPatientInstitution;
    }

    public PatientInstitution(Integer idPatientInstitution, int idPatient, int idInstitution) {
	this.idPatientInstitution = idPatientInstitution;
	this.idPatient = idPatient;
	this.idInstitution = idInstitution;
    }

    public Integer getIdPatientInstitution() {
	return idPatientInstitution;
    }

    public void setIdPatientInstitution(Integer idPatientInstitution) {
	this.idPatientInstitution = idPatientInstitution;
    }

    public int getIdPatient() {
	return idPatient;
    }

    public void setIdPatient(int idPatient) {
	this.idPatient = idPatient;
    }

    public int getIdInstitution() {
	return idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
	this.idInstitution = idInstitution;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idPatientInstitution != null ? idPatientInstitution.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientInstitution)) {
	    return false;
	}
	PatientInstitution other = (PatientInstitution) object;
	if ((this.idPatientInstitution == null && other.idPatientInstitution != null) || (this.idPatientInstitution != null && !this.idPatientInstitution.equals(other.idPatientInstitution))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientInstitution[ idPatientInstitution=" + idPatientInstitution + " ]";
    }
    
}
