/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap.test;

import com.mycompany.soap.config.Conn;
import com.google.gson.Gson;
import com.mycompany.soap.dao.UsuarioDao;
import com.mycompany.soap.daoImpl.UsuarioDaoImpl;

/**
 *
 * @author Saul
 */
public class Test {
    static Gson gson = new Gson();
    static UsuarioDao u = new UsuarioDaoImpl(); 
    public static void main(String[] args) {
        if (Conn.getConn() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error");
        }
    }
}
