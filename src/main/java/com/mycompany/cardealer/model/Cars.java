/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cardealer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RENT
 */
@Entity
@Table(name = "cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findById", query = "SELECT c FROM Cars c WHERE c.id = :id"),
    @NamedQuery(name = "Cars.findByColor", query = "SELECT c FROM Cars c WHERE c.color = :color"),
    @NamedQuery(name = "Cars.findByYear", query = "SELECT c FROM Cars c WHERE c.year = :year"),
    @NamedQuery(name = "Cars.findByPrice", query = "SELECT c FROM Cars c WHERE c.price = :price")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @JoinColumn(name = "id_model", referencedColumnName = "id")
    @ManyToOne
    private Models idModel;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private Status statusId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne
    private CarTypes typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCar")
    private Collection<TestDrives> testDrivesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCar")
    private Collection<Sales> salesCollection;

    public Cars() {
    }

    public Cars(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Models getIdModel() {
        return idModel;
    }

    public void setIdModel(Models idModel) {
        this.idModel = idModel;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public CarTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(CarTypes typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public Collection<TestDrives> getTestDrivesCollection() {
        return testDrivesCollection;
    }

    public void setTestDrivesCollection(Collection<TestDrives> testDrivesCollection) {
        this.testDrivesCollection = testDrivesCollection;
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
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cardealer.model.Cars[ id=" + id + " ]";
    }
    
}
