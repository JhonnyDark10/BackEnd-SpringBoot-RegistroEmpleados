package com.proyecto.AsistenciaEmpleados.controllers;


import com.proyecto.AsistenciaEmpleados.models.SisArea;
import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import com.proyecto.AsistenciaEmpleados.services.AreasServices;
import com.proyecto.AsistenciaEmpleados.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200",maxAge  = 3600)
@RestController
@RequestMapping("/areas")
public class AreasController {

    @Autowired
   AreasServices areasServices;


    @GetMapping()
    public ArrayList<SisArea> obtenerListadoAreas(){
        return areasServices.obtenerListadoAreas();
    }
}
