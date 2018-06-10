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
@Table(name = "patient_vacctination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientVacctination.findAll", query = "SELECT p FROM PatientVacctination p")})
public class PatientVacctination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatientVacctination")
    private Integer idPatientVacctination;
    @Basic(optional = false)
    @Column(name = "vacctinationDate")
    @Temporal(TemporalType.DATE)
    private Date vacctinationDate;
    @Basic(optional = false)
    @Column(name = "dose")
    private double dose;
    @Basic(optional = false)
    @Column(name = "series")
    private String series;
    @Basic(optional = false)
    @Column(name = "idPatient")
    private int idPatient;
    @Basic(optional = false)
    @Column(name = "idVacctination")
    private int idVacctination;

    public PatientVacctination() {
    }

    public PatientVacctination(Integer idPatientVacctination) {
	this.idPatientVacctination = idPatientVacctination;
    }

    public PatientVacctination(Integer idPatientVacctination, Date vacctinationDate, double dose, String series, int idPatient, int idVacctination) {
	this.idPatientVacctination = idPatientVacctination;
	this.vacctinationDate = vacctinationDate;
	this.dose = dose;
	this.series = series;
	this.idPatient = idPatient;
	this.idVacctination = idVacctination;
    }

    public Integer getIdPatientVacctination() {
	return idPatientVacctination;
    }

    public void setIdPatientVacctination(Integer idPatientVacctination) {
	this.idPatientVacctination = idPatientVacctination;
    }

    public Date getVacctinationDate() {
	return vacctinationDate;
    }

    public void setVacctinationDate(Date vacctinationDate) {
	this.vacctinationDate = vacctinationDate;
    }

    public double getDose() {
	return dose;
    }

    public void setDose(double dose) {
	this.dose = dose;
    }

    public String getSeries() {
	return series;
    }

    public void setSeries(String series) {
	this.series = series;
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
	hash += (idPatientVacctination != null ? idPatientVacctination.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientVacctination)) {
	    return false;
	}
	PatientVacctination other = (PatientVacctination) object;
	if ((this.idPatientVacctination == null && other.idPatientVacctination != null) || (this.idPatientVacctination != null && !this.idPatientVacctination.equals(other.idPatientVacctination))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientVacctination[ idPatientVacctination=" + idPatientVacctination + " ]";
    }
    
}
