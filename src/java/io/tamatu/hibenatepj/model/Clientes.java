/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibenatepj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author titonitola-maturana
 */
@Entity
@Table(name="clientes")
public class Clientes {

    public Clientes() {
    }

    public Clientes(String Nombres, String Apellidos, String Direccion) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return "Clientes{" + "Id=" + Id + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion + '}';
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;
    /**
     * Identity sequencing uses special IDENTITY columns in the database to 
     * allow the database to automatically assign an id to the object when its 
     * row is inserted. Identity columns are supported in many databases, such 
     * as MySQL, DB2, SQL Server, Sybase and Postgres. Oracle does not support 
     * IDENTITY columns but they can be simulated through using sequence objects 
     * and triggers.
     */
    @Column(name="Nombres")
    private String Nombres;
    @Column(name="Apellidos")
    private String Apellidos;
    @Column(name="Direccion")
    private String Direccion;
}
