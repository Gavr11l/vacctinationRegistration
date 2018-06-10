/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author testtest
 */
@Entity
@Table(name = "patient_vacctinationfault")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientVacctinationFault.findAll", query = "SELECT p FROM PatientVacctinationFault p")})
public class PatientVacctinationFault implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatientVacctinationFault")
    private Integer idPatientVacctinationFault;
    @Basic(optional = false)
    @Column(name = "faultReason")
    private String faultReason;
    @Basic(optional = false)
    @Column(name = "faultTime")
    private String faultTime;
    @Basic(optional = false)
    @Column(name = "idVacctination")
    private int idVacctination;
    @Basic(optional = false)
    @Column(name = "idPatient")
    private int idPatient;
    @Basic(optional = false)
    @Column(name = "vacctinationFaultDate")
    @Temporal(TemporalType.DATE)
    private Date vacctinationFaultDate;

    public PatientVacctinationFault() {
    }

    public PatientVacctinationFault(Integer idPatientVacctinationFault) {
	this.idPatientVacctinationFault = idPatientVacctinationFault;
    }

    public PatientVacctinationFault(Integer idPatientVacctinationFault, String faultReason, String faultTime, int idVacctination, int idPatient, Date vacctinationFaultDate) {
	this.idPatientVacctinationFault = idPatientVacctinationFault;
	this.faultReason = faultReason;
	this.faultTime = faultTime;
	this.idVacctination = idVacctination;
	this.idPatient = idPatient;
	this.vacctinationFaultDate = vacctinationFaultDate;
    }

    public Integer getIdPatientVacctinationFault() {
	return idPatientVacctinationFault;
    }

    public void setIdPatientVacctinationFault(Integer idPatientVacctinationFault) {
	this.idPatientVacctinationFault = idPatientVacctinationFault;
    }

    public String getFaultReason() {
	return faultReason;
    }

    public void setFaultReason(String faultReason) {
	this.faultReason = faultReason;
    }

    public String getFaultTime() {
	return faultTime;
    }

    public void setFaultTime(String faultTime) {
	this.faultTime = faultTime;
    }

    public int getIdVacctination() {
	return idVacctination;
    }

    public void setIdVacctination(int idVacctination) {
	this.idVacctination = idVacctination;
    }

    public int getIdPatient() {
	return idPatient;
    }

    public void setIdPatient(int idPatient) {
	this.idPatient = idPatient;
    }

    public Date getVacctinationFaultDate() {
	return vacctinationFaultDate;
    }

    public void setVacctinationFaultDate(Date vacctinationFaultDate) {
	this.vacctinationFaultDate = vacctinationFaultDate;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idPatientVacctinationFault != null ? idPatientVacctinationFault.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientVacctinationFault)) {
	    return false;
	}
	PatientVacctinationFault other = (PatientVacctinationFault) object;
	if ((this.idPatientVacctinationFault == null && other.idPatientVacctinationFault != null) || (this.idPatientVacctinationFault != null && !this.idPatientVacctinationFault.equals(other.idPatientVacctinationFault))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientVacctinationFault[ idPatientVacctinationFault=" + idPatientVacctinationFault + " ]";
    }
    
}
