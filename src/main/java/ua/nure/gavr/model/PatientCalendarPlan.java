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
@Table(name = "patient_calendarplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientCalendarPlan.findAll", query = "SELECT p FROM PatientCalendarPlan p")})
public class PatientCalendarPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatientCalendarPlan")
    private Integer idPatientCalendarPlan;
    @Basic(optional = false)
    @Column(name = "vacctinationDate")
    @Temporal(TemporalType.DATE)
    private Date vacctinationDate;
    @Basic(optional = false)
    @Column(name = "idPatient")
    private int idPatient;
    @Basic(optional = false)
    @Column(name = "idVacctination")
    private int idVacctination;

    public PatientCalendarPlan() {
    }

    public PatientCalendarPlan(Integer idPatientCalendarPlan) {
	this.idPatientCalendarPlan = idPatientCalendarPlan;
    }

    public PatientCalendarPlan(Integer idPatientCalendarPlan, Date vacctinationDate, int idPatient, int idVacctination) {
	this.idPatientCalendarPlan = idPatientCalendarPlan;
	this.vacctinationDate = vacctinationDate;
	this.idPatient = idPatient;
	this.idVacctination = idVacctination;
    }

    public Integer getIdPatientCalendarPlan() {
	return idPatientCalendarPlan;
    }

    public void setIdPatientCalendarPlan(Integer idPatientCalendarPlan) {
	this.idPatientCalendarPlan = idPatientCalendarPlan;
    }

    public Date getVacctinationDate() {
	return vacctinationDate;
    }

    public void setVacctinationDate(Date vacctinationDate) {
	this.vacctinationDate = vacctinationDate;
    }

    public int getIdPatient() {
	return idPatient;
    }

    public void setIdPatient(int idPatient) {
	this.idPatient = idPatient;
    }

    public int getIdVacctination() {
	return idVacctination;
    }

    public void setIdVacctination(int idVacctination) {
	this.idVacctination = idVacctination;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idPatientCalendarPlan != null ? idPatientCalendarPlan.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientCalendarPlan)) {
	    return false;
	}
	PatientCalendarPlan other = (PatientCalendarPlan) object;
	if ((this.idPatientCalendarPlan == null && other.idPatientCalendarPlan != null) || (this.idPatientCalendarPlan != null && !this.idPatientCalendarPlan.equals(other.idPatientCalendarPlan))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientCalendarPlan[ idPatientCalendarPlan=" + idPatientCalendarPlan + " ]";
    }
    
}
