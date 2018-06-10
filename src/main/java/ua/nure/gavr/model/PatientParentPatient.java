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
@Table(name = "patientparent_patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientParentPatient.findAll", query = "SELECT p FROM PatientParentPatient p")})
public class PatientParentPatient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatientParentPatient")
    private Integer idPatientParentPatient;
    @Basic(optional = false)
    @Column(name = "idPatientParent")
    private int idPatientParent;
    @Basic(optional = false)
    @Column(name = "idPatient")
    private int idPatient;

    public PatientParentPatient() {
    }

    public PatientParentPatient(Integer idPatientParentPatient) {
	this.idPatientParentPatient = idPatientParentPatient;
    }

    public PatientParentPatient(Integer idPatientParentPatient, int idPatientParent, int idPatient) {
	this.idPatientParentPatient = idPatientParentPatient;
	this.idPatientParent = idPatientParent;
	this.idPatient = idPatient;
    }

    public Integer getIdPatientParentPatient() {
	return idPatientParentPatient;
    }

    public void setIdPatientParentPatient(Integer idPatientParentPatient) {
	this.idPatientParentPatient = idPatientParentPatient;
    }

    public int getIdPatientParent() {
	return idPatientParent;
    }

    public void setIdPatientParent(int idPatientParent) {
	this.idPatientParent = idPatientParent;
    }

    public int getIdPatient() {
	return idPatient;
    }

    public void setIdPatient(int idPatient) {
	this.idPatient = idPatient;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idPatientParentPatient != null ? idPatientParentPatient.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientParentPatient)) {
	    return false;
	}
	PatientParentPatient other = (PatientParentPatient) object;
	if ((this.idPatientParentPatient == null && other.idPatientParentPatient != null) || (this.idPatientParentPatient != null && !this.idPatientParentPatient.equals(other.idPatientParentPatient))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientParentPatient[ idPatientParentPatient=" + idPatientParentPatient + " ]";
    }
    
}
