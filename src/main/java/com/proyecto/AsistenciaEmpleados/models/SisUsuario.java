package com.proyecto.AsistenciaEmpleados.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "sis_usuarios")
public class SisUsuario implements Serializable {
    private static final long serialVersionUID = -2969524610059270447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id_pais")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private SisPai usuIdPais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id_area")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private SisArea usuIdArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id_tipo")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private SisTipoidentificacion usuIdTipo;

    @Column(name = "usu_apellido_paterno", nullable = false, length = 20)
    private String usuApellidoPaterno;

    @Column(name = "usu_apellido_materno", nullable = false, length = 20)
    private String usuApellidoMaterno;

    @Column(name = "usu_primer_nombre", nullable = false, length = 20)
    private String usuPrimerNombre;

    @Column(name = "usu_segundo_nombre", nullable = false, length = 20)
    private String usuSegundoNombre;

    @Column(name = "usu_numero_identificacion", nullable = false, length = 20)
    private String usuNumeroIdentificacion;

    @Column(name = "usu_fecha_ingreso")
    private LocalDate usuFechaIngreso;

    @Column(name = "usu_fecha_edicion")
    private LocalDate usuFechaEdicion;

    @Column(name = "usu_fechahora_registro")
    private LocalDate usuFechahoraRegistro;

    @Column(name = "usu_estado", nullable = false)
    private Character usuEstado;

    @Column(name = "usu_correo", nullable = false)
    private String usuCorreo;

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SisPai getUsuIdPais() {
        return usuIdPais;
    }

    public void setUsuIdPais(SisPai usuIdPais) {
        this.usuIdPais = usuIdPais;
    }

    public SisArea getUsuIdArea() {
        return usuIdArea;
    }

    public void setUsuIdArea(SisArea usuIdArea) {
        this.usuIdArea = usuIdArea;
    }

    public SisTipoidentificacion getUsuIdTipo() {
        return usuIdTipo;
    }

    public void setUsuIdTipo(SisTipoidentificacion usuIdTipo) {
        this.usuIdTipo = usuIdTipo;
    }

    public String getUsuApellidopaterno() {
        return usuApellidoPaterno;
    }

    public void setUsuApellidopaterno(String usuApellidoPaterno) {
        this.usuApellidoPaterno = usuApellidoPaterno;
    }

    public String getUsuApellidomaterno() {
        return usuApellidoMaterno;
    }

    public void setUsuApellidomaterno(String usuApellidomaterno) {
        this.usuApellidoMaterno = usuApellidomaterno;
    }

    public String getUsuPrimernombre() {
        return usuPrimerNombre;
    }

    public void setUsuPrimernombre(String usuPrimernombre) {
        this.usuPrimerNombre = usuPrimernombre;
    }

    public String getUsuSegundonombre() {
        return usuSegundoNombre;
    }

    public void setUsuSegundonombre(String usuSegundonombre) {
        this.usuSegundoNombre = usuSegundonombre;
    }

    public String getUsuNumeroidentificacion() {
        return usuNumeroIdentificacion;
    }

    public void setUsuNumeroidentificacion(String usuNumeroidentificacion) {
        this.usuNumeroIdentificacion = usuNumeroidentificacion;
    }

    public LocalDate getUsuFechaingreso() {
        return usuFechaIngreso;
    }

    public void setUsuFechaingreso(LocalDate usuFechaingreso) {
        this.usuFechaIngreso = usuFechaingreso;
    }

    public LocalDate getUsuFechaedicion() {
        return usuFechaEdicion;
    }

    public void setUsuFechaedicion(LocalDate usuFechaedicion) {
        this.usuFechaEdicion = usuFechaedicion;
    }

    public LocalDate getUsuFechahoraregistro() {
        return usuFechahoraRegistro;
    }

    public void setUsuFechahoraregistro(LocalDate usuFechahoraregistro) {
        this.usuFechahoraRegistro = usuFechahoraregistro;
    }

    public Character getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Character usuEstado) {
        this.usuEstado = usuEstado;
    }

}