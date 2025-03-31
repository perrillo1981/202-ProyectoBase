/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.puntodeventa.services;

import com.puntodeventa.persistance.dao.UsuarioDao;

/**
 *
 * @author reneloreaayala
 */
public class UsuarioService {
    
    UsuarioDao usuDao=new UsuarioDao();
    
    public boolean validaUsuario(String usuario,String password){
        return usuDao.validaUsuario(usuario, password);
    }
    
}
