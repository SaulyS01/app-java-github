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

    static UsuarioDao dao = new UsuarioDaoImpl();

    @WebMethod(operationName = "crear")
    public int crear(@WebParam(name = "username") String username, @WebParam(name = "password") String password,
            @WebParam(name = "idpersona") int idpersona, @WebParam(name = "idrol") int idrol) {
        return dao.create(new Usuario(0, username, password, idpersona, idrol, "", false));
    }

    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "idusuario") int idusuario, @WebParam(name = "username") String username, @WebParam(name = "password") String password,
            @WebParam(name = "idpersona") int idpersona, @WebParam(name = "idrol") int idrol) {
        return dao.update(new Usuario(idusuario, username, password, idpersona, idrol, "", false));
    }

    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idusuario") int idusuario) {
        return dao.delete(idusuario);
    }

    @WebMethod(operationName = "read")
    public Usuario read(@WebParam(name = "idusuario") int idusuario) {
        return dao.read(idusuario);
    }

    @WebMethod(operationName = "readAll")
    public List<Usuario> readAll() {
        return dao.readAll();
    }
}
