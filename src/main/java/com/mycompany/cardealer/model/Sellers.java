/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cardealer.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RENT
 */
@Entity
@Table(name = "sellers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sellers.findAll", query = "SELECT s FROM Sellers s"),
    @NamedQuery(name = "Sellers.findById", query = "SELECT s FROM Sellers s WHERE s.id = :id"),
    @NamedQuery(name = "Sellers.findByFirstName", query = "SELECT s FROM Sellers s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Sellers.findByLastName", query = "SELECT s FROM Sellers s WHERE s.lastName = :lastName")})
public class Sellers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeller")
    private Collection<Invoices> invoicesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeller")
    private Collection<TestDrives> testDrivesCollection;

    public Sellers() {
    }

    public Sellers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    @XmlTransient
    public Collection<TestDrives> getTestDrivesCollection() {
        return testDrivesCollection;
    }

    public void setTestDrivesCollection(Collection<TestDrives> testDrivesCollection) {
        this.testDrivesCollection = testDrivesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sellers)) {
            return false;
        }
        Sellers other = (Sellers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cardealer.model.Sellers[ id=" + id + " ]";
    }
    
}
