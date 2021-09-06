/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibenatepj.pruebahb;

import io.tamatu.hibenatepj.model.Cliente;
import io.tamatu.hibenatepj.model.DetalleCliente;
import io.tamatu.hibenatepj.model.Pedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class PruebaOneToOne {
    public static void main(String[] args){
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(DetalleCliente.class)
                .addAnnotatedClass(Pedido.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            Cliente cliente1 = new Cliente("Tito", "Maturana", "Edificio UGI");
            DetalleCliente detalle1 = new DetalleCliente("www", "3333333", "no comments");
            cliente1.setDetalleCliente(detalle1);
            //cliente1.setPedidos(null);
            
            miSession.beginTransaction();
            miSession.save(cliente1);
            
            System.out.println("Registro Finalizado Cliente: " + cliente1.getId());
            System.out.println("Detalle: " + cliente1.getDetalleCliente().getId());
            
        } catch(Exception exc){
            exc.printStackTrace();
        } finally{
            miSession.close();
            miFactoria.close();
        }
    }
}
