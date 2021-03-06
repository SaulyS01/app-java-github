package com.mycompany.soap.daoImpl;

import com.mycompany.soap.config.Conn;
import com.mycompany.soap.dao.UsuarioDao;
import com.mycompany.soap.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioDaoImpl implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cn;

    @Override
    public List<Usuario> readAll() {
        List<Usuario> lista = new ArrayList<>();
        try {
            String SQL = "select * from usuarios";
            cn = Conn.getConn();
            ps = cn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setIdpersona(rs.getInt("idpersona"));
                user.setIdrol(rs.getInt("idrol"));
                user.setFecha(rs.getString("fechacreacion"));
                user.setEstado(rs.getBoolean("estado"));
                lista.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return lista;
    }

    @Override
    public int create(Usuario user) {
        int x = 0;
        boolean estado = false;
        String SQL = "insert into usuarios(username, password, idpersona, idrol, now(), true) values(?, ?, ?, ?)";
        try {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdpersona());
            ps.setInt(4, user.getIdrol());
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public int update(Usuario user) {
        int x = 0;
        boolean estado = false;
        String SQL = "update usuarios set username=?, password=?, idpersona=?, idrol=?) where idusuario=?";
        try {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdpersona());
            ps.setInt(4, user.getIdrol());
            ps.setInt(5, user.getIdusuario());
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    @Override
    public Usuario read(int id) {
        Usuario user = new Usuario();
        int estado = 0;
        String SQL = "select * from usuarios where idusuario=?";
        try {
            cn = Conn.getConn();
            ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setIdpersona(rs.getInt("idpersona"));
                user.setIdrol(rs.getInt("idrol"));
                user.setFecha(rs.getString("fechacreacion"));
                user.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL = "update usuarios set estado=false where idusuario=id";
        try {
            cn = Conn.getConn();
            ps = cn.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return x;
    }

    /*@Override
    public List<Map<String, Object>> readAll2() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String SQL = "select u.idusuario, u.username, p.apellidos, p.nombres, r.nombre  from usuarios as u "
                + "inner join roles as r on u.idrol = r.idrol "
                + "inner join personas as p on u.idpersona = p.idpersona ";
        try {
            cn = Conn.getConn();
            ps = cn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idusuario", rs.getInt("idusuario"));
                map.put("username", rs.getString("username"));
                map.put("apellidos", rs.getString("apellidos"));
                map.put("nombres", rs.getString("nombres"));
                map.put("rol", rs.getString("nombre"));
                lista.add(map);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return lista;
    }*/
}
