/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdt.edu.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diep Nguyen
 */
@Entity
@Table(name = "MANAGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m")
    , @NamedQuery(name = "Manager.findById", query = "SELECT m FROM Manager m WHERE m.id = :id")
    , @NamedQuery(name = "Manager.findByUsername", query = "SELECT m FROM Manager m WHERE m.username = :username")
    , @NamedQuery(name = "Manager.findByName", query = "SELECT m FROM Manager m WHERE m.name = :name")
    , @NamedQuery(name = "Manager.findByBirth", query = "SELECT m FROM Manager m WHERE m.birth = :birth")
    , @NamedQuery(name = "Manager.findByRole", query = "SELECT m FROM Manager m WHERE m.role = :role")
    , @NamedQuery(name = "Manager.findByGender", query = "SELECT m FROM Manager m WHERE m.gender = :gender")
    , @NamedQuery(name = "Manager.findByPhonenumber", query = "SELECT m FROM Manager m WHERE m.phonenumber = :phonenumber")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTH")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE")
    private int role;
    @Size(max = 8)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 2147483647)
    @Column(name = "PHONENUMBER")
    private String phonenumber;

    public Manager() {
    }

    public Manager(String username) {
        this.username = username;
    }

    public Manager(String username, int id, String name, int role) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tdt.edu.persistence.Manager[ username=" + username + " ]";
    }
    
}
