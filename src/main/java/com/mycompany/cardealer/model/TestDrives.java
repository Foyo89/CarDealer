/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cardealer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RENT
 */
@Entity
@Table(name = "test_drives")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestDrives.findAll", query = "SELECT t FROM TestDrives t"),
    @NamedQuery(name = "TestDrives.findById", query = "SELECT t FROM TestDrives t WHERE t.id = :id"),
    @NamedQuery(name = "TestDrives.findByDate", query = "SELECT t FROM TestDrives t WHERE t.date = :date")})
public class TestDrives implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "id_car", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cars idCar;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clients idClient;
    @JoinColumn(name = "id_seller", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sellers idSeller;

    public TestDrives() {
    }

    public TestDrives(Integer id) {
        this.id = id;
    }

    public TestDrives(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cars getIdCar() {
        return idCar;
    }

    public void setIdCar(Cars idCar) {
        this.idCar = idCar;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Sellers getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Sellers idSeller) {
        this.idSeller = idSeller;
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
        if (!(object instanceof TestDrives)) {
            return false;
        }
        TestDrives other = (TestDrives) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cardealer.model.TestDrives[ id=" + id + " ]";
    }
    
}
