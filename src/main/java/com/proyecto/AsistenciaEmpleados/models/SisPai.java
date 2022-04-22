package com.proyecto.AsistenciaEmpleados.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sis_pais")
public class SisPai implements Serializable {
    private static final long serialVersionUID = -2969524610059270447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id", nullable = false)
    private Integer id;

    @Column(name = "pais_descripcion", nullable = false, length = 50)
    private String paisDescripcion;

    @Column(name = "pais_estado", nullable = false)
    private Character paisEstado;



    //bi-directional many-to-one association to SegPermiso
    @OneToMany(mappedBy="usuIdPais")
    private List<SisUsuario> sisUsuario;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaisDescripcion() {
        return paisDescripcion;
    }

    public void setPaisDescripcion(String paisDescripcion) {
        this.paisDescripcion = paisDescripcion;
    }

    public Character getPaisEstado() {
        return paisEstado;
    }

    public void setPaisEstado(Character paisEstado) {
        this.paisEstado = paisEstado;
    }


}