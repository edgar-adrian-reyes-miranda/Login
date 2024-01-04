package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.logueo.spring.Entity.*;

import lombok.*;
@Data
public class DatosFTDDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String area;
    private Date fecha_ingreso;
    private Date fecha_termino;
    private String correo_becario;
    private int matricula_ftd;
    private List<Cursos> cursos;
    private EstatusInfotec estatusInfotec;
    private Modalidad modalidad;
    private Enlace enlace;
     private Grupos grupos;
     private Tutores tutores;
     private List<DatosPersonales> datosPersonales;
}
