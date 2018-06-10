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
@Table(name = "patient_vacctinationrenouncement")
@XmlRootElement
public class PatientVacctinationRenouncement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatient_vacctinationRenouncement")
    private Integer idPatientvacctinationRenouncement;
    @Basic(optional = false)
    @Column(name = "renouncementDate")
    @Temporal(TemporalType.DATE)
    private Date renouncementDate;
    @Basic(optional = false)
    @Column(name = "renouncementTime")
    private String renouncementTime;
    @Basic(optional = false)
    @Column(name = "idPatient")
    private int idPatient;
    @Basic(optional = false)
    @Column(name = "idVacctination")
    private int idVacctination;
    @Basic(optional = false)
    @Column(name = "idPatientParent")
    private int idPatientParent;

    public Integer getIdPatientvacctinationRenouncement() {
	return idPatientvacctinationRenouncement;
    }

    public void setIdPatientvacctinationRenouncement(Integer idPatientvacctinationRenouncement) {
	this.idPatientvacctinationRenouncement = idPatientvacctinationRenouncement;
    }

    public Date getRenouncementDate() {
	return renouncementDate;
    }

    public void setRenouncementDate(Date renouncementDate) {
	this.renouncementDate = renouncementDate;
    }

    public String getRenouncementTime() {
	return renouncementTime;
    }

    public void setRenouncementTime(String renouncementTime) {
	this.renouncementTime = renouncementTime;
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

    public int getIdPatientParent() {
	return idPatientParent;
    }

    public void setIdPatientParent(int idPatientParent) {
	this.idPatientParent = idPatientParent;
    }


    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientVacctinationRenouncement)) {
	    return false;
	}
	PatientVacctinationRenouncement other = (PatientVacctinationRenouncement) object;
	if ((this.idPatientvacctinationRenouncement == null && other.idPatientvacctinationRenouncement != null) || (this.idPatientvacctinationRenouncement != null && !this.idPatientvacctinationRenouncement.equals(other.idPatientvacctinationRenouncement))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientVacctinationRenouncement[ idPatientvacctinationRenouncement=" + idPatientvacctinationRenouncement + " ]";
    }
    
}
