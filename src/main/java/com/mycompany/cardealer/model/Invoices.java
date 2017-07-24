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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "invoices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findById", query = "SELECT i FROM Invoices i WHERE i.id = :id"),
    @NamedQuery(name = "Invoices.findBySygnature", query = "SELECT i FROM Invoices i WHERE i.sygnature = :sygnature")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "sygnature")
    private String sygnature;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clients idClient;
    @JoinColumn(name = "id_seller", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sellers idSeller;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInvoice")
    private Collection<Sales> salesCollection;

    public Invoices() {
    }

    public Invoices(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSygnature() {
        return sygnature;
    }

    public void setSygnature(String sygnature) {
        this.sygnature = sygnature;
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

    @XmlTransient
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
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
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cardealer.model.Invoices[ id=" + id + " ]";
    }
    
}
