package com.mycompany.soap.dao;

import com.mycompany.soap.model.Usuario;
import java.util.List;
import java.util.Map;

public interface UsuarioDao {
    List<Usuario> readAll();
    int create(Usuario user);
    int update(Usuario user);
    Usuario read(int id);
    int delete(int id);
    List<Map<String, Object>> readAll2();
}

