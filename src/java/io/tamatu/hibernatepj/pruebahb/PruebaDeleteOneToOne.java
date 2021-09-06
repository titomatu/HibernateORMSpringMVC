/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibernatepj.pruebahb;

import io.tamatu.hibernatepj.model.Cliente;
import io.tamatu.hibernatepj.model.DetalleCliente;
import io.tamatu.hibernatepj.model.Pedido;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class PruebaDeleteOneToOne {
    public static void main(String[] args){
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(DetalleCliente.class)
                .addAnnotatedClass(Pedido.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            miSession.beginTransaction();
            
            Optional<Cliente> cliente1 = miSession.byId(Cliente.class).loadOptional(3);
            
            if(cliente1.isPresent()){
                System.out.println("Registro encontrado Cliente: " + cliente1.get().getId());
                System.out.println("Registro encontrado Detalle: " + cliente1.get().getDetalleCliente().getId());
                
                //Transacción para eliminar el registro
                miSession.delete(cliente1.get());
                miSession.getTransaction().commit();
                System.out.println("Cliente-Detalle eliminados correctamente!!!");
            } else {
                System.out.println("Cliente no existe!!!");
            }
            
        } catch(Exception exc){
            exc.printStackTrace();
        } finally{
            miSession.close();
            miFactoria.close();
        }
    }
}
