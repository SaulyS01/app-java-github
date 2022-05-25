/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap.ws;

import com.mycompany.soap.dao.UsuarioDao;
import com.mycompany.soap.daoImpl.UsuarioDaoImpl;
import com.mycompany.soap.model.Usuario;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Saul
 */
@WebService(serviceName = "UsuarioWebService")
public class UsuarioWebService {

    private UsuarioDao dao = new UsuarioDaoImpl();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "readAllUsuario")
    public List<Usuario> readAllUsuario() {
        return dao.readAll();
    }

    @WebMethod(operationName = "readAll2")
    public List<Map<String, Object>> readAll2() {
        return dao.readAll2();
    }
}
