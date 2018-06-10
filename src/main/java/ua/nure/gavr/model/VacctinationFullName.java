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
@Table(name = "vacctinationfullname")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VacctinationFullName.findAll", query = "SELECT v FROM VacctinationFullName v")})
public class VacctinationFullName implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacctionationalFullName")
    private Integer idVacctionationalFullName;
    @Basic(optional = false)
    @Column(name = "fullName")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "idVacctination")
    private int idVacctination;

    public VacctinationFullName() {
    }

    public VacctinationFullName(Integer idVacctionationalFullName) {
	this.idVacctionationalFullName = idVacctionationalFullName;
    }

    public VacctinationFullName(Integer idVacctionationalFullName, String fullName, int idVacctination) {
	this.idVacctionationalFullName = idVacctionationalFullName;
	this.fullName = fullName;
	this.idVacctination = idVacctination;
    }

    public Integer getIdVacctionationalFullName() {
	return idVacctionationalFullName;
    }

    public void setIdVacctionationalFullName(Integer idVacctionationalFullName) {
	this.idVacctionationalFullName = idVacctionationalFullName;
    }

    public String getFullName() {
	return fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
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
	hash += (idVacctionationalFullName != null ? idVacctionationalFullName.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof VacctinationFullName)) {
	    return false;
	}
	VacctinationFullName other = (VacctinationFullName) object;
	if ((this.idVacctionationalFullName == null && other.idVacctionationalFullName != null) || (this.idVacctionationalFullName != null && !this.idVacctionationalFullName.equals(other.idVacctionationalFullName))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.VacctinationFullName[ idVacctionationalFullName=" + idVacctionationalFullName + " ]";
    }
    
}
