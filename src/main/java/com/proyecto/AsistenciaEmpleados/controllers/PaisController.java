package com.proyecto.AsistenciaEmpleados.controllers;

import com.proyecto.AsistenciaEmpleados.models.SisArea;
import com.proyecto.AsistenciaEmpleados.models.SisPai;
import com.proyecto.AsistenciaEmpleados.services.AreasServices;
import com.proyecto.AsistenciaEmpleados.services.PaisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200",maxAge  = 3600)
@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisServices paisServices;


    @GetMapping()
    public ArrayList<SisPai> obtenerListadoPaises(){
        return paisServices.obtenerListadoPaises();
    }
}
