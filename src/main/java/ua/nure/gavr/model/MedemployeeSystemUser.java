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
@Table(name = "medemployee_systemuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedemployeeSystemUser.findAll", query = "SELECT m FROM MedemployeeSystemUser m")})
public class MedemployeeSystemUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedEmployeeSysemUser")
    private Integer idmedEmployeeSysemUser;
    @Basic(optional = false)
    @Column(name = "idMedEmployee")
    private int idMedEmployee;
    @Basic(optional = false)
    @Column(name = "idSystemUser")
    private int idSystemUser;

    public MedemployeeSystemUser() {
    }

    public MedemployeeSystemUser(Integer idmedEmployeeSysemUser) {
	this.idmedEmployeeSysemUser = idmedEmployeeSysemUser;
    }

    public MedemployeeSystemUser(Integer idmedEmployeeSysemUser, int idMedEmployee, int idSystemUser) {
	this.idmedEmployeeSysemUser = idmedEmployeeSysemUser;
	this.idMedEmployee = idMedEmployee;
	this.idSystemUser = idSystemUser;
    }

    public Integer getIdmedEmployeeSysemUser() {
	return idmedEmployeeSysemUser;
    }

    public void setIdmedEmployeeSysemUser(Integer idmedEmployeeSysemUser) {
	this.idmedEmployeeSysemUser = idmedEmployeeSysemUser;
    }

    public int getIdMedEmployee() {
	return idMedEmployee;
    }

    public void setIdMedEmployee(int idMedEmployee) {
	this.idMedEmployee = idMedEmployee;
    }

    public int getIdSystemUser() {
	return idSystemUser;
    }

    public void setIdSystemUser(int idSystemUser) {
	this.idSystemUser = idSystemUser;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idmedEmployeeSysemUser != null ? idmedEmployeeSysemUser.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof MedemployeeSystemUser)) {
	    return false;
	}
	MedemployeeSystemUser other = (MedemployeeSystemUser) object;
	if ((this.idmedEmployeeSysemUser == null && other.idmedEmployeeSysemUser != null) || (this.idmedEmployeeSysemUser != null && !this.idmedEmployeeSysemUser.equals(other.idmedEmployeeSysemUser))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.MedemployeeSystemUser[ idmedEmployeeSysemUser=" + idmedEmployeeSysemUser + " ]";
    }
    
}
