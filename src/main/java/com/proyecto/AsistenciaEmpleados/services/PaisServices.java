package com.proyecto.AsistenciaEmpleados.services;

import com.proyecto.AsistenciaEmpleados.models.SisArea;
import com.proyecto.AsistenciaEmpleados.models.SisPai;
import com.proyecto.AsistenciaEmpleados.repositoy.AreaRepository;
import com.proyecto.AsistenciaEmpleados.repositoy.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaisServices {

    @Autowired
    PaisRepository paisRepository;

    public ArrayList<SisPai> obtenerListadoPaises(){
        return (ArrayList<SisPai>) paisRepository.findAll();
    }
}
