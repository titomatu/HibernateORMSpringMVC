/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibernatepj.pruebahb;

import io.tamatu.hibernatepj.model.Cliente;
import io.tamatu.hibernatepj.model.DetalleCliente;
import io.tamatu.hibernatepj.model.Pedido;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class GuardaPedido {
    public static void main(String[] args) {
        
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(DetalleCliente.class)
                .addAnnotatedClass(Pedido.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            Cliente cliente1 = new Cliente("Santiago", "Nitola", "Vancity");
            cliente1.setDetalleCliente(new DetalleCliente("www", "3333333", "no comments"));
            cliente1.agregarPedido(new Pedido("tarjeta", LocalDate.now()));
            cliente1.agregarPedido(new Pedido("tarjeta1", LocalDate.now()));
            cliente1.agregarPedido(new Pedido("tarjeta2", LocalDate.now()));
            
            miSession.beginTransaction();
            miSession.save(cliente1);
            
            cliente1.getPedidos().stream()
                    .forEach(p -> miSession.save(p));
            
            
        } catch(Exception exc){
            exc.printStackTrace();
        } finally{
            miSession.close();
            miFactoria.close();
        }
    }
}
