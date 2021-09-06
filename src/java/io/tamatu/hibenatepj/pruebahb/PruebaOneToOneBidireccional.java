/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibenatepj.pruebahb;

import io.tamatu.hibenatepj.model.Cliente;
import io.tamatu.hibenatepj.model.DetalleCliente;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class PruebaOneToOneBidireccional {
    public static void main(String[] args){
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(DetalleCliente.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            miSession.beginTransaction();
            
            //Searchin by the other direction, from detalle cliente to cliente
            Optional<DetalleCliente> detalle1 = miSession.byId(DetalleCliente.class).loadOptional(1);
            
            if(detalle1.isPresent()){
                System.out.println("Registro encontrado Cliente: " + detalle1.get().toString());
                System.out.println("Registro encontrado Detalle: " + detalle1.get().getCliente().toString());
                
            } else {
                System.out.println("Detalle Cliente no existe!!!");
            }
            
        } catch(Exception exc){
            exc.printStackTrace();
        } finally{
            miSession.close();
            miFactoria.close();
        }
    }
}
