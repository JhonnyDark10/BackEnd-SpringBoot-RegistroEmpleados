package com.proyecto.AsistenciaEmpleados.services;

import com.proyecto.AsistenciaEmpleados.models.SisArea;
import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import com.proyecto.AsistenciaEmpleados.repositoy.AreaRepository;
import com.proyecto.AsistenciaEmpleados.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AreasServices {


    @Autowired
    AreaRepository areaRepository;

    public ArrayList<SisArea> obtenerListadoAreas(){
        return (ArrayList<SisArea>) areaRepository.findAll();
    }

}
