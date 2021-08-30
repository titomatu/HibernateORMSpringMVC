/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibenatepj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class GuardaClientePrueba {
    public static void main(String[] args){
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            Clientes cliente1 = new Clientes("Tito Andrés", "Maturana de la Cruz", "Chapinero");
            
            miSession.beginTransaction();
            miSession.save(cliente1);
            miSession.getTransaction().commit();
            
            System.out.println("Registro Finalizado");
        } finally {
            miSession.close();
            miFactoria.close();
        }
    }
}
