package com.logueo.spring.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.logueo.spring.Entity.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class DatosFTDDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String area;
    private String fecha_ingreso;
    private String fecha_termino;
    private String correo_becario;
    private String matricula_ftd;
    private String beca;
    private String becadocumenot;

    private List<Cursos> cursos;

    private EstatusInfotec estatusInfotec;

    private Enlace enlace;

    private Grupos grupos;

    private Tutores tutores;

    private List<Proyectos> proyectos;

    private DatosPersonales datosPersonales;
}
