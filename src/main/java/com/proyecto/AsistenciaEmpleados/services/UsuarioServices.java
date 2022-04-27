package com.proyecto.AsistenciaEmpleados.services;


import com.proyecto.AsistenciaEmpleados.models.SisUsuario;
import com.proyecto.AsistenciaEmpleados.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class UsuarioServices {

    @Autowired
    UsuarioRepository usuarioRepository;


    public ArrayList<SisUsuario> obtenerUsuarios(){
        return (ArrayList<SisUsuario>) usuarioRepository.findAll();
    }

    public ArrayList<SisUsuario> obtenerUsuariosTotales(){
        return (ArrayList<SisUsuario>) usuarioRepository.findAll();
    }

    @Transactional
    public SisUsuario guardarUsuario(SisUsuario usuario){
        boolean valida = validarRestricciones(usuario);
        if(valida){

            boolean validaFecha = validarRestriccionesFecha(usuario);
            if (validaFecha) {
                SisUsuario usuarioDatos = crearCorreoAutomatico(usuario);

                LocalDate fechaRegistro = LocalDate.now();
                LocalDateTime fechahoraRegistro = LocalDateTime.now();

                usuarioDatos.setUsuFechahoraregistro(fechahoraRegistro);
                usuarioDatos.setUsuFechaedicion(fechaRegistro);

                usuarioDatos.setUsuEstado('A');
                return usuarioRepository.save(usuarioDatos);
            }else{
                throw new DuplicateKeyException("La fecha de ingreso no debe ser superior a la fecha actual " +
                        "y menor a 30 dias");
            }
        }
        throw new DuplicateKeyException("Ya existe un registro con el " +
                "mismo tipo y numero de identificación: ");
    }

    public Optional<SisUsuario> obtenerPorId(Integer id){
        return usuarioRepository.findById(id);
    }

    @Transactional
    public SisUsuario editarUusuario(SisUsuario usuario) {

        boolean valida = validarRestricciones(usuario);
        if(valida){

            SisUsuario usuarioDatos = crearCorreoAutomatico(usuario);
            LocalDate fechaEdicion = LocalDate.now();
            usuarioDatos.setUsuFechaedicion(fechaEdicion);

            return usuarioRepository.save(usuarioDatos);
        }
        throw new DuplicateKeyException("Ya existe un registro con el " +
                "mismo tipo y numero de identificación: ");
    }

    public boolean eliminarUsuario(Integer id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public SisUsuario crearCorreoAutomatico(SisUsuario usuario){
        String dominio ="";
        if (usuario.getUsuIdPais().getId() == 1){
            dominio="cidenet.com.co";
        }else{
            dominio="cidenet.com.us";
        }
        String Nombrecorreo = usuario.getUsuPrimernombre() + "." + usuario.getUsuApellidopaterno();
        String correo = Nombrecorreo + "@" + dominio;

        //obtener todos los usuarios
        ArrayList<SisUsuario> lista;
        lista = obtenerUsuariosTotales();
        int n=1;
        for (int i=0;i<lista.size();i++) {
            if(lista.get(i).getUsuCorreo().equals(correo)){

                String dato = Nombrecorreo + n;
                correo = dato + "@" + dominio;
                usuario.setUsuCorreo(correo);
                n++;
            }else{
                usuario.setUsuCorreo(correo);
            }
        }
        return usuario;
    }


    public boolean validarRestricciones(SisUsuario usuario){

        ArrayList<SisUsuario> lista;
        lista = obtenerUsuariosTotales();

        for (int i=0;i<lista.size();i++) {
            if(lista.get(i).getUsuIdTipo().getId() == usuario.getUsuIdTipo().getId()
                    && lista.get(i).getUsuNumeroidentificacion().equals(usuario.getUsuNumeroidentificacion())){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean validarRestriccionesFecha(SisUsuario usuario){


        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        LocalDate firstDate = LocalDate.now();
        LocalDate secondDate = usuario.getUsuFechaingreso();

        Date FechaActual = Date.valueOf(firstDate);
        Date FechaEnvio = Date.valueOf(secondDate);

        long diff = FechaActual.getTime() - FechaEnvio.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);


       if(diferencia <= 30){
           if (usuario.getUsuFechaingreso().isBefore(firstDate)  ||
                   usuario.getUsuFechaingreso().isEqual(firstDate))
           {
               return true;
           }else {
               return false;
           }
       }else{
           return false;
       }
    }


}
