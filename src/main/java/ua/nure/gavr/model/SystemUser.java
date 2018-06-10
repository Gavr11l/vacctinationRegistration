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
@Table(name = "systemuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemUser.findAll", query = "SELECT s FROM SystemUser s")})
public class SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSystemUser")
    private Integer idSystemUser;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public SystemUser() {
    }

    public SystemUser(Integer idSystemUser) {
	this.idSystemUser = idSystemUser;
    }

    public SystemUser(Integer idSystemUser, String login, String password) {
	this.idSystemUser = idSystemUser;
	this.login = login;
	this.password = password;
    }

    public Integer getIdSystemUser() {
	return idSystemUser;
    }

    public void setIdSystemUser(Integer idSystemUser) {
	this.idSystemUser = idSystemUser;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idSystemUser != null ? idSystemUser.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof SystemUser)) {
	    return false;
	}
	SystemUser other = (SystemUser) object;
	if ((this.idSystemUser == null && other.idSystemUser != null) || (this.idSystemUser != null && !this.idSystemUser.equals(other.idSystemUser))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "ua.nure.cs_13_3.cw.gavr.model.SystemUser[ idSystemUser=" + idSystemUser + " ]";
    }
    
}
