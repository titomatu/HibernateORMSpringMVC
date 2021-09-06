/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibenatepj.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author titonitola-maturana
 */
@Entity
@Table(name="detalle_cliente")
public class DetalleCliente {

    public DetalleCliente() {
    }

    public DetalleCliente(String web, String telefono, String comentarios) {
        this.web = web;
        this.telefono = telefono;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return "DetalleCliente{" + "id=" + id + ", web=" + web + ", telefono=" + telefono + ", comentarios=" + comentarios + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id;
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
        final DetalleCliente other = (DetalleCliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="web")
    private String web;
    @Column(name="tfno")
    private String telefono;
    @Column(name="comentarios")
    private String comentarios;
    
    @OneToOne(mappedBy="detalleCliente", cascade=CascadeType.ALL) //Tipo de relación y cascada
    private Cliente cliente; //mappedBy -> relación One To One bidireccional
}
