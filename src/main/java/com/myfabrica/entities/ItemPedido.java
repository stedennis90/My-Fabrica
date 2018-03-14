/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dennis
 */
@Entity
@Table(name = "ITEM_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPedido.findAll", query = "SELECT i FROM ItemPedido i")
    , @NamedQuery(name = "ItemPedido.findById", query = "SELECT i FROM ItemPedido i WHERE i.id = :id")
    , @NamedQuery(name = "ItemPedido.findByCantidad", query = "SELECT i FROM ItemPedido i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "ItemPedido.findByPrecio", query = "SELECT i FROM ItemPedido i WHERE i.precio = :precio")})
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 7, scale = 2)
    private BigDecimal precio;
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Pedido idPedido;
    @JoinColumn(name = "ID_PRENDA", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Prenda idPrenda;

    public ItemPedido() {
    }

    public ItemPedido(Long id) {
        this.id = id;
    }

    public ItemPedido(Long id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Prenda getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(Prenda idPrenda) {
        this.idPrenda = idPrenda;
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
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfabrica.entities.ItemPedido[ id=" + id + " ]";
    }
    
}
