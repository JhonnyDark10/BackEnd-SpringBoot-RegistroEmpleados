package com.proyecto.AsistenciaEmpleados.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sis_tipoidentificacion")
public class SisTipoidentificacion implements Serializable {
    private static final long serialVersionUID = -2969524610059270447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_identificacion_id", nullable = false)
    private Integer id;

    @Column(name = "tipo_identificacion_descripcion", nullable = false, length = 50)
    private String tipoIdentificacionDescripcion;

    @Column(name = "tipo_identificacion_estado", nullable = false)
    private Character tipoIdentificacionEstado;


    @OneToMany(mappedBy="usuIdTipo")
    private List<SisUsuario> sisUsuario;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoidentificacionDescripcion() {
        return tipoIdentificacionDescripcion;
    }

    public void setTipoidentificacionDescripcion(String tipoidentificacionDescripcion) {
        this.tipoIdentificacionDescripcion = tipoidentificacionDescripcion;
    }

    public Character getTipoidentificacionEstado() {
        return tipoIdentificacionEstado;
    }

    public void setTipoidentificacionEstado(Character tipoidentificacionEstado) {
        this.tipoIdentificacionEstado = tipoidentificacionEstado;
    }


}