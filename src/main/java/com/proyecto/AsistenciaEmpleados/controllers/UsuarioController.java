package com.proyecto.AsistenciaEmpleados.controllers;

import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import com.proyecto.AsistenciaEmpleados.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
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
    public SisUsuario guardarUsuarios(@RequestBody SisUsuario usuario){

        String dominio ="";
        if (usuario.getUsuIdPais().getId() == 1){
            dominio="cidenet.com.co";
        }else{
            dominio="cidenet.com.us";
        }
        String Nombrecorreo = usuario.getUsuPrimernombre().toString() + "." + usuario.getUsuApellidopaterno().toString();

        String correo = Nombrecorreo + "@" + dominio;


        ArrayList<SisUsuario> lista;
        lista = usuarioServices.obtenerUsuarios();

        for (int i=0;i<lista.size();i++) {

            if(lista.get(i).getUsuCorreo() == correo){
                String dato = Nombrecorreo + "1";
                correo = dato + "@" + dominio;
                usuario.setUsuCorreo(correo);
                break;
            }else{
                usuario.setUsuCorreo(correo);
            }
        }



        LocalDate fechaRegistro = LocalDate.now();
        usuario.setUsuFechahoraregistro(fechaRegistro);
        usuario.setUsuFechaedicion(fechaRegistro);

        usuario.setUsuEstado('A');
        return this.usuarioServices.guardarUsuario(usuario);
    }


    @GetMapping( path = "/{id}")
    public Optional<SisUsuario> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        return this.usuarioServices.obtenerPorId(id);
    }

    @PutMapping(path = "/{id}")
    public SisUsuario editar(@RequestBody SisUsuario usuario,@PathVariable("id") Integer id){
        usuario.setId(id);

        String dominio ="";
        if (usuario.getUsuIdPais().getId() == 1){
            dominio="cidenet.com.co";
        }else{
            dominio="cidenet.com.us";
        }
        String Nombrecorreo = usuario.getUsuPrimernombre().toString() + "." + usuario.getUsuApellidopaterno().toString();

        String correo = Nombrecorreo + "@" + dominio;


        ArrayList<SisUsuario> lista;
        lista = usuarioServices.obtenerUsuarios();

        for (int i=0;i<lista.size();i++) {

            if(lista.get(i).getUsuCorreo() == correo){
                String dato = Nombrecorreo + "1";
                correo = dato + "@" + dominio;
                usuario.setUsuCorreo(correo);
                break;
            }else{
                usuario.setUsuCorreo(correo);
            }
        }

      return this.usuarioServices.editarUusuario(usuario);
    }



    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.usuarioServices.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
