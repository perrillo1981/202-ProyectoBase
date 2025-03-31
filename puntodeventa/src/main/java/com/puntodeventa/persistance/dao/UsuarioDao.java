/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.puntodeventa.persistance.dao;

import com.puntodeventa.persistance.conexion.ConexionBaseDatos;
import com.puntodeventa.persistance.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reneloreaayala
 */
public class UsuarioDao {
    
    public boolean validaUsuario(String usuario, String password){
        boolean flag=false;
        List<Usuario> listaUsuarios=new ArrayList<Usuario>();
        try {
            Connection conn = ConexionBaseDatos.connectDatabase();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            Usuario u=new Usuario();
            rs = stmt.executeQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"' and password='"+password+"'");
            while ( rs.next() ) {
                u.setId(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setPassword(rs.getString(3));
                listaUsuarios.add(u);
                flag=true;
            }
            
            conn.close();
            return flag;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return flag;
    }
    
}
