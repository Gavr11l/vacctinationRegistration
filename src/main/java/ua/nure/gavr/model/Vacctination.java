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
@Table(name = "vacctination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacctination.findAll", query = "SELECT v FROM Vacctination v")})
public class Vacctination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacctination")
    private Integer idVacctination;
    @Basic(optional = false)
    @Column(name = "vacctinationType")
    private String vacctinationType;

    public Vacctination() {
    }

    public Vacctination(Integer idVacctination) {
	this.idVacctination = idVacctination;
    }

    public Vacctination(Integer idVacctination, String vacctinationType) {
	this.idVacctination = idVacctination;
	this.vacctinationType = vacctinationType;
    }

    public Integer getIdVacctination() {
	return idVacctination;
    }

    public void setIdVacctination(Integer idVacctination) {
	this.idVacctination = idVacctination;
    }

    public String getVacctinationType() {
	return vacctinationType;
    }

    public void setVacctinationType(String vacctinationType) {
	this.vacctinationType = vacctinationType;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idVacctination != null ? idVacctination.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Vacctination)) {
	    return false;
	}
	Vacctination other = (Vacctination) object;
	if ((this.idVacctination == null && other.idVacctination != null) || (this.idVacctination != null && !this.idVacctination.equals(other.idVacctination))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.Vacctination[ idVacctination=" + idVacctination + " ]";
    }
    
}
