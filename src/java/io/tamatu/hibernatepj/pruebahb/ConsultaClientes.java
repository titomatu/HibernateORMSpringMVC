/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibernatepj.pruebahb;

import io.tamatu.hibernatepj.model.Clientes;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author titonitola-maturana
 */
public class ConsultaClientes {
    public static void main(String[] args){
        SessionFactory miFactoria = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();
        
        Session miSession = miFactoria.openSession();
        
        try{
            miSession.beginTransaction();
            
            //Consulta de clientes, nombre de la tabla en HQL es de 
            //la entidad mapeada
            Stream<Clientes> clientes = miSession.createQuery("from Clientes cl where cl.Apellidos = 'Nitola'").getResultStream();
            
            clientes.forEach(p -> System.out.println(p.toString()));
        } finally {
            miSession.close();
            miFactoria.close();
        }
    }
}
