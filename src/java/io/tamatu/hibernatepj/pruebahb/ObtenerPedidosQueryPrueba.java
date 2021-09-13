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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author titonitola-maturana
 */
public class ObtenerPedidosQueryPrueba {
    public static void main(String[] args) {
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(DetalleCliente.class)
                .addAnnotatedClass(Pedido.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            Query<Cliente> query = miSession.createQuery(
                    "SELECT CL FROM Cliente CL JOIN FETCH CL.pedidos WHERE CL.id=:cliente_id", 
                    Cliente.class);
            
            query.setParameter("cliente_id", 4);
            
            Cliente cliente = query.getSingleResult();
            cliente.getPedidos().stream()
                        .forEach(p -> System.out.println(p.toString()));
            
            
        } catch (Exception exc){
            exc.printStackTrace();
        } finally {
            miSession.close();
            miFactoria.close();
        }
    
    }
}
