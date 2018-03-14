/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dennis
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prenda.findAll", query = "SELECT p FROM Prenda p")
    , @NamedQuery(name = "Prenda.findById", query = "SELECT p FROM Prenda p WHERE p.id = :id")
    , @NamedQuery(name = "Prenda.findByCodigo", query = "SELECT p FROM Prenda p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Prenda.findByNombre", query = "SELECT p FROM Prenda p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Prenda.findByDescripcion", query = "SELECT p FROM Prenda p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Prenda.findByImagen", query = "SELECT p FROM Prenda p WHERE p.imagen = :imagen")})
public class Prenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;
    @Size(max = 500)
    @Column(length = 500)
    private String descripcion;
    @Size(max = 200)
    @Column(length = 200)
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrenda")
    private Collection<ItemPedido> itemPedidoCollection;
    @JoinColumn(name = "ID_TIPO_PRENDA", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TipoPrenda idTipoPrenda;

    public Prenda() {
    }

    public Prenda(Long id) {
        this.id = id;
    }

    public Prenda(Long id, int codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<ItemPedido> getItemPedidoCollection() {
        return itemPedidoCollection;
    }

    public void setItemPedidoCollection(Collection<ItemPedido> itemPedidoCollection) {
        this.itemPedidoCollection = itemPedidoCollection;
    }

    public TipoPrenda getIdTipoPrenda() {
        return idTipoPrenda;
    }

    public void setIdTipoPrenda(TipoPrenda idTipoPrenda) {
        this.idTipoPrenda = idTipoPrenda;
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
        if (!(object instanceof Prenda)) {
            return false;
        }
        Prenda other = (Prenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfabrica.entities.Prenda[ id=" + id + " ]";
    }
    
}
