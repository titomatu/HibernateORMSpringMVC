/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibernatepj.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author titonitola-maturana
 */
@Entity
@Table(name="cliente")
public class Cliente {

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public DetalleCliente getDetalleCliente() {
        return detalleCliente;
    }

    public void setDetalleCliente(DetalleCliente detalleCliente) {
        this.detalleCliente = detalleCliente;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void agregarPedido(Pedido pedido){
        if(this.pedidos == null) this.pedidos = new ArrayList<Pedido>();
        
        this.pedidos.add(pedido);
        pedido.setCliente(this);
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id; 
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="direccion")
    private String direccion;
    
    @OneToOne(cascade=CascadeType.ALL) //Tipo de relación y cascada
    @JoinColumn(name="id") //ColumnaJoin
    private DetalleCliente detalleCliente;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="cliente", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Pedido> pedidos;
    /**
     * EAGER -> Get all the info available ina a relationship between 2 tables
     * LAZY -> Get all the infor when it is needed - On Demand
     * 
     * Default Fetch Values:
     * OneToOne     EAGER
     * OneToMany    LAZY
     * ManyToOne    EAGER
     * ManyToMany   LAZY
     */
}
