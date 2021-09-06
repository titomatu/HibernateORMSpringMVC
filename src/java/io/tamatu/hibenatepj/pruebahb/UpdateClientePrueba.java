/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibenatepj.pruebahb;

import io.tamatu.hibenatepj.Clientes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class UpdateClientePrueba {
    public static void main(String[] args){
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            miSession.beginTransaction();
            Clientes cliente1 = miSession.get(Clientes.class, 2);
            //Modificamos las propiedades
            cliente1.setNombres("Saniago Andrés");
            cliente1.setApellidos("Nitola Sandoval");
            //Commit de la transacción
            miSession.getTransaction().commit();
            
            //2 forma: con HQL
            miSession.beginTransaction();
            miSession.createQuery("update Clientes cl set cl.Nombres='Tito Andrés'" + 
                    " where cl.Id=3").executeUpdate();
            miSession.getTransaction().commit();
        } finally {
            miSession.close();
            miFactoria.close();
        }
    }
}
