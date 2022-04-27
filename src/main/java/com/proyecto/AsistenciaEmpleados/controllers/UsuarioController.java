package com.proyecto.AsistenciaEmpleados.controllers;

import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import com.proyecto.AsistenciaEmpleados.services.UsuarioServices;
import javax.validation.Valid;
import com.proyecto.AsistenciaEmpleados.util.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge  = 3600)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping()
    public ArrayList<SisUsuario> obtenerUsuarios(){
        return usuarioServices.obtenerUsuarios();
    }


    @PostMapping()
    public SisUsuario guardarUsuarios(@Valid @RequestBody SisUsuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
         return this.usuarioServices.guardarUsuario(usuario);
    }


    @GetMapping( path = "/{id}")
    public Optional<SisUsuario> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        return this.usuarioServices.obtenerPorId(id);
    }

    @PutMapping(path = "/{id}")
    public SisUsuario editar(@RequestBody SisUsuario usuario,@PathVariable("id") Integer id){
        usuario.setId(id);

        return this.usuarioServices.editarUusuario(usuario);
    }



    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.usuarioServices.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id " + id;
        }
    }



}
