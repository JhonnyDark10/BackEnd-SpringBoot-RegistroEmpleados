package com.proyecto.AsistenciaEmpleados.services;

import com.proyecto.AsistenciaEmpleados.models.SisTipoidentificacion;
import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import com.proyecto.AsistenciaEmpleados.repositoy.TipoRepository;
import com.proyecto.AsistenciaEmpleados.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoServices {

    @Autowired
    TipoRepository tipoRepository;

    public ArrayList<SisTipoidentificacion> obtenerTipos(){
        return (ArrayList<SisTipoidentificacion>) tipoRepository.findAll();
    }

}
