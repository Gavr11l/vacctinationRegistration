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
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatient")
    private Integer idPatient;
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
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @Column(name = "placeOfResidenceArea")
    private String placeOfResidenceArea;
    @Basic(optional = false)
    @Column(name = "placeOfResidenceCity")
    private String placeOfResidenceCity;
    @Basic(optional = false)
    @Column(name = "placeOfResidenceDistrict")
    private String placeOfResidenceDistrict;
    @Column(name = "placeOfResidenceLocality")
    private String placeOfResidenceLocality;
    @Basic(optional = false)
    @Column(name = "placeOfResidenceStreet")
    private String placeOfResidenceStreet;
    @Basic(optional = false)
    @Column(name = "placeOfResidenceHouseNumber")
    private int placeOfResidenceHouseNumber;
    @Column(name = "placeOfResidenceHousingNumber")
    private Integer placeOfResidenceHousingNumber;
    @Column(name = "placeOfResidenceFlatNumber")
    private Integer placeOfResidenceFlatNumber;
    @Basic(optional = false)
    @Column(name = "sex")
    private String sex;

    public Patient() {
    }

    public Patient(Integer idPatient) {
	this.idPatient = idPatient;
    }

    public Patient(Integer idPatient, String lastName, String middleName, String firstName, Date birthday, String placeOfResidenceArea, String placeOfResidenceCity, String placeOfResidenceDistrict, String placeOfResidenceStreet, int placeOfResidenceHouseNumber, String sex) {
	this.idPatient = idPatient;
	this.lastName = lastName;
	this.middleName = middleName;
	this.firstName = firstName;
	this.birthday = birthday;
	this.placeOfResidenceArea = placeOfResidenceArea;
	this.placeOfResidenceCity = placeOfResidenceCity;
	this.placeOfResidenceDistrict = placeOfResidenceDistrict;
	this.placeOfResidenceStreet = placeOfResidenceStreet;
	this.placeOfResidenceHouseNumber = placeOfResidenceHouseNumber;
	this.sex = sex;
    }

    public Integer getIdPatient() {
	return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
	this.idPatient = idPatient;
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

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    public String getPlaceOfResidenceArea() {
	return placeOfResidenceArea;
    }

    public void setPlaceOfResidenceArea(String placeOfResidenceArea) {
	this.placeOfResidenceArea = placeOfResidenceArea;
    }

    public String getPlaceOfResidenceCity() {
	return placeOfResidenceCity;
    }

    public void setPlaceOfResidenceCity(String placeOfResidenceCity) {
	this.placeOfResidenceCity = placeOfResidenceCity;
    }

    public String getPlaceOfResidenceDistrict() {
	return placeOfResidenceDistrict;
    }

    public void setPlaceOfResidenceDistrict(String placeOfResidenceDistrict) {
	this.placeOfResidenceDistrict = placeOfResidenceDistrict;
    }

    public String getPlaceOfResidenceLocality() {
	return placeOfResidenceLocality;
    }

    public void setPlaceOfResidenceLocality(String placeOfResidenceLocality) {
	this.placeOfResidenceLocality = placeOfResidenceLocality;
    }

    public String getPlaceOfResidenceStreet() {
	return placeOfResidenceStreet;
    }

    public void setPlaceOfResidenceStreet(String placeOfResidenceStreet) {
	this.placeOfResidenceStreet = placeOfResidenceStreet;
    }

    public int getPlaceOfResidenceHouseNumber() {
	return placeOfResidenceHouseNumber;
    }

    public void setPlaceOfResidenceHouseNumber(int placeOfResidenceHouseNumber) {
	this.placeOfResidenceHouseNumber = placeOfResidenceHouseNumber;
    }

    public Integer getPlaceOfResidenceHousingNumber() {
	return placeOfResidenceHousingNumber;
    }

    public void setPlaceOfResidenceHousingNumber(Integer placeOfResidenceHousingNumber) {
	this.placeOfResidenceHousingNumber = placeOfResidenceHousingNumber;
    }

    public Integer getPlaceOfResidenceFlatNumber() {
	return placeOfResidenceFlatNumber;
    }

    public void setPlaceOfResidenceFlatNumber(Integer placeOfResidenceFlatNumber) {
	this.placeOfResidenceFlatNumber = placeOfResidenceFlatNumber;
    }

    public String getSex() {
	return sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idPatient != null ? idPatient.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Patient)) {
	    return false;
	}
	Patient other = (Patient) object;
	if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.Patient[ idPatient=" + idPatient + " ]";
    }
    
}
