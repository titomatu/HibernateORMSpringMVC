/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.tamatu.hibenatepj;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author titonitola-maturana
 */
public class PruebaJDBC {
    public static void main(String[] args){
        try{
            //1. Crear conexión con la interfaz Connection
            Connection conn = //
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebashibernate", "root", "azrael0526");
            
            System.out.println("Conexión exitosa!!!");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
