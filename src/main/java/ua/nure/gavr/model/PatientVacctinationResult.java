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
@Table(name = "patient_vacctinationresult")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientVacctinationResult.findAll", query = "SELECT p FROM PatientVacctinationResult p")})
public class PatientVacctinationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatientVacctinationResult")
    private Integer idPatientVacctinationResult;
    @Basic(optional = false)
    @Column(name = "localReaction")
    private String localReaction;
    @Basic(optional = false)
    @Column(name = "globalReaction")
    private String globalReaction;
    @Basic(optional = false)
    @Column(name = "result")
    private String result;
    @Basic(optional = false)
    @Column(name = "idPatientVacctination")
    private int idPatientVacctination;

    public PatientVacctinationResult() {
    }

    public PatientVacctinationResult(Integer idPatientVacctinationResult) {
	this.idPatientVacctinationResult = idPatientVacctinationResult;
    }

    public PatientVacctinationResult(Integer idPatientVacctinationResult, String localReaction, String globalReaction, String result, int idPatientVacctination) {
	this.idPatientVacctinationResult = idPatientVacctinationResult;
	this.localReaction = localReaction;
	this.globalReaction = globalReaction;
	this.result = result;
	this.idPatientVacctination = idPatientVacctination;
    }

    public Integer getIdPatientVacctinationResult() {
	return idPatientVacctinationResult;
    }

    public void setIdPatientVacctinationResult(Integer idPatientVacctinationResult) {
	this.idPatientVacctinationResult = idPatientVacctinationResult;
    }

    public String getLocalReaction() {
	return localReaction;
    }

    public void setLocalReaction(String localReaction) {
	this.localReaction = localReaction;
    }

    public String getGlobalReaction() {
	return globalReaction;
    }

    public void setGlobalReaction(String globalReaction) {
	this.globalReaction = globalReaction;
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public int getIdPatientVacctination() {
	return idPatientVacctination;
    }

    public void setIdPatientVacctination(int idPatientVacctination) {
	this.idPatientVacctination = idPatientVacctination;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idPatientVacctinationResult != null ? idPatientVacctinationResult.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof PatientVacctinationResult)) {
	    return false;
	}
	PatientVacctinationResult other = (PatientVacctinationResult) object;
	if ((this.idPatientVacctinationResult == null && other.idPatientVacctinationResult != null) || (this.idPatientVacctinationResult != null && !this.idPatientVacctinationResult.equals(other.idPatientVacctinationResult))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.PatientVacctinationResult[ idPatientVacctinationResult=" + idPatientVacctinationResult + " ]";
    }
    
}
