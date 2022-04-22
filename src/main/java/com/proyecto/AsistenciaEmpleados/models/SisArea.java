package com.proyecto.AsistenciaEmpleados.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sis_area")
public class SisArea implements Serializable {
    private static final long serialVersionUID = -2969524610059270447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id", nullable = false)
    private Integer id;

    @Column(name = "area_descripcion", nullable = false, length = 50)
    private String areaDescripcion;

    @Column(name = "area_estado", nullable = false)
    private Character areaEstado;

    //bi-directional many-to-one association to SegPermiso
    @OneToMany(mappedBy="usuIdArea")
    private List<SisUsuario> sisUsuario;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaDescripcion() {
        return areaDescripcion;
    }

    public void setAreaDescripcion(String areaDescripcion) {
        this.areaDescripcion = areaDescripcion;
    }

    public Character getAreaEstado() {
        return areaEstado;
    }

    public void setAreaEstado(Character areaEstado) {
        this.areaEstado = areaEstado;
    }

}