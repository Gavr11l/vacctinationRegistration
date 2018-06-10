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
@Table(name = "patientparent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientParent.findAll", query = "SELECT p FROM PatientParent p")})
public class PatientParent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatientParent")
    private Integer idPatientParent;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "middleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;

    public PatientParent() {
    }

    public PatientParent(Integer idPatientParent) {
	this.idPatientParent = idPatientParent;
    }

    public PatientParent(Integer idPatientParent, String lastName, String middleName, String firstName) {
	this.idPatientParent = idPatientParent;
	this.lastName = lastName;
	this.middleName = middleName;
	this.firstName = firstName;
    }

    public Integer getIdPatientParent() {
	return idPatientParent;
    }

    public void setIdPatientParent(Integer idPatientParent) {
	this.idPatientParent = idPatientParent;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getMiddleName() {
	return middleName;
    }

    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idPatientParent != null ? idPatientParent.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientParent)) {
	    return false;
	}
	PatientParent other = (PatientParent) object;
	if ((this.idPatientParent == null && other.idPatientParent != null) || (this.idPatientParent != null && !this.idPatientParent.equals(other.idPatientParent))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientParent[ idPatientParent=" + idPatientParent + " ]";
    }
    
}
