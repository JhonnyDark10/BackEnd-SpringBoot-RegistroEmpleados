package com.proyecto.AsistenciaEmpleados.controllers;

import com.proyecto.AsistenciaEmpleados.models.SisPai;
import com.proyecto.AsistenciaEmpleados.models.SisTipoidentificacion;
import com.proyecto.AsistenciaEmpleados.services.PaisServices;
import com.proyecto.AsistenciaEmpleados.services.TipoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200",maxAge  = 3600)
@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    TipoServices tipoServices;


    @GetMapping()
    public ArrayList<SisTipoidentificacion> obtenerTipos(){
        return tipoServices.obtenerTipos();
    }
}
