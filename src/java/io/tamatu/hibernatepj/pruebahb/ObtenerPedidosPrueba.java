/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibernatepj.pruebahb;

import io.tamatu.hibernatepj.model.Cliente;
import io.tamatu.hibernatepj.model.DetalleCliente;
import io.tamatu.hibernatepj.model.Pedido;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class ObtenerPedidosPrueba {
    public static void main(String[] args) {
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(DetalleCliente.class)
                .addAnnotatedClass(Pedido.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            Optional<Cliente> cliente1 = miSession.byId(Cliente.class)
                    .loadOptional(4);
            
            if(cliente1.isPresent()){
                Cliente cliente = cliente1.get();
                System.out.println("Cliente: " + cliente.toString());
                
                //Only it is neccesary to call the getter and Hibernate does the rest
                cliente.getPedidos().stream()
                        .forEach(p -> System.out.println(p.toString()));
            }
        } catch (Exception exc){
            exc.printStackTrace();
        } finally {
            miSession.close();
            miFactoria.close();
        }
    
    }
}
