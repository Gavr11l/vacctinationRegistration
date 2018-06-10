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
@Table(name = "institution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i")})
public class Institution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInstitution")
    private Integer idInstitution;
    @Basic(optional = false)
    @Column(name = "institutionName")
    private String institutionName;
    @Basic(optional = false)
    @Column(name = "adressArea")
    private String adressArea;
    @Basic(optional = false)
    @Column(name = "adressCity")
    private String adressCity;
    @Basic(optional = false)
    @Column(name = "adressDistrict")
    private String adressDistrict;
    @Basic(optional = false)
    @Column(name = "adressStreet")
    private String adressStreet;
    @Basic(optional = false)
    @Column(name = "adressHouseNumber")
    private int adressHouseNumber;

    public Institution() {
    }

    public Institution(Integer idInstitution) {
	this.idInstitution = idInstitution;
    }

    public Institution(Integer idInstitution, String institutionName, String adressArea, String adressCity, String adressDistrict, String adressStreet, int adressHouseNumber) {
	this.idInstitution = idInstitution;
	this.institutionName = institutionName;
	this.adressArea = adressArea;
	this.adressCity = adressCity;
	this.adressDistrict = adressDistrict;
	this.adressStreet = adressStreet;
	this.adressHouseNumber = adressHouseNumber;
    }

    public Integer getIdInstitution() {
	return idInstitution;
    }

    public void setIdInstitution(Integer idInstitution) {
	this.idInstitution = idInstitution;
    }

    public String getInstitutionName() {
	return institutionName;
    }

    public void setInstitutionName(String institutionName) {
	this.institutionName = institutionName;
    }

    public String getAdressArea() {
	return adressArea;
    }

    public void setAdressArea(String adressArea) {
	this.adressArea = adressArea;
    }

    public String getAdressCity() {
	return adressCity;
    }

    public void setAdressCity(String adressCity) {
	this.adressCity = adressCity;
    }

    public String getAdressDistrict() {
	return adressDistrict;
    }

    public void setAdressDistrict(String adressDistrict) {
	this.adressDistrict = adressDistrict;
    }

    public String getAdressStreet() {
	return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
	this.adressStreet = adressStreet;
    }

    public int getAdressHouseNumber() {
	return adressHouseNumber;
    }

    public void setAdressHouseNumber(int adressHouseNumber) {
	this.adressHouseNumber = adressHouseNumber;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idInstitution != null ? idInstitution.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Institution)) {
	    return false;
	}
	Institution other = (Institution) object;
	if ((this.idInstitution == null && other.idInstitution != null) || (this.idInstitution != null && !this.idInstitution.equals(other.idInstitution))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.Institution[ idInstitution=" + idInstitution + " ]";
    }
    
}
