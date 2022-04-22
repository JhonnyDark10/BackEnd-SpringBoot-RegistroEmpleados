package com.proyecto.AsistenciaEmpleados.services;


import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import com.proyecto.AsistenciaEmpleados.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServices {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<SisUsuario> obtenerUsuarios(){
        return (ArrayList<SisUsuario>) usuarioRepository.findAll();
    }

    public SisUsuario guardarUsuario(SisUsuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<SisUsuario> obtenerPorId(Integer id){
        return usuarioRepository.findById(id);
    }

    public SisUsuario editarUusuario(SisUsuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean eliminarUsuario(Integer id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
