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
@Table(name = "medemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medemployee.findAll", query = "SELECT m FROM Medemployee m")})
public class Medemployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedEmployee")
    private Integer idMedEmployee;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "middleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "post")
    private String post;

    public Medemployee() {
    }

    public Medemployee(Integer idMedEmployee) {
	this.idMedEmployee = idMedEmployee;
    }

    public Medemployee(Integer idMedEmployee, String lastName, String middleName, String firstName, String post) {
	this.idMedEmployee = idMedEmployee;
	this.lastName = lastName;
	this.middleName = middleName;
	this.firstName = firstName;
	this.post = post;
    }

    public Integer getIdMedEmployee() {
	return idMedEmployee;
    }

    public void setIdMedEmployee(Integer idMedEmployee) {
	this.idMedEmployee = idMedEmployee;
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

    public String getPost() {
	return post;
    }

    public void setPost(String post) {
	this.post = post;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idMedEmployee != null ? idMedEmployee.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Medemployee)) {
	    return false;
	}
	Medemployee other = (Medemployee) object;
	if ((this.idMedEmployee == null && other.idMedEmployee != null) || (this.idMedEmployee != null && !this.idMedEmployee.equals(other.idMedEmployee))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.Medemployee[ idMedEmployee=" + idMedEmployee + " ]";
    }
    
}
