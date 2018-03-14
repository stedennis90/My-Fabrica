/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dennis
 */
@Entity
@Table(name = "TIPO_PRENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrenda.findAll", query = "SELECT t FROM TipoPrenda t")
    , @NamedQuery(name = "TipoPrenda.findById", query = "SELECT t FROM TipoPrenda t WHERE t.id = :id")
    , @NamedQuery(name = "TipoPrenda.findByNombre", query = "SELECT t FROM TipoPrenda t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoPrenda.findByPrecio", query = "SELECT t FROM TipoPrenda t WHERE t.precio = :precio")})
public class TipoPrenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPrenda")
    private Collection<Prenda> prendaCollection;

    public TipoPrenda() {
    }

    public TipoPrenda(Long id) {
        this.id = id;
    }

    public TipoPrenda(Long id, String nombre, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Prenda> getPrendaCollection() {
        return prendaCollection;
    }

    public void setPrendaCollection(Collection<Prenda> prendaCollection) {
        this.prendaCollection = prendaCollection;
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
        if (!(object instanceof TipoPrenda)) {
            return false;
        }
        TipoPrenda other = (TipoPrenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfabrica.entities.TipoPrenda[ id=" + id + " ]";
    }
    
}
