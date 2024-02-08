package com.logueo.spring.DTO;

import com.logueo.spring.Entity.*;
import lombok.Data;
import java.io.Serializable;

@Data
public class DatosFTDDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String area;
    private String beca;
    private String becadocumenot;
    private String fecha_ingreso;
    private String fecha_termino;
    private String matricula_ftd;
    private String correo_becario;

    private Proyectos proyectos;

    private Tutores tutores;

    private Grupos grupos;

    private Enlace enlace;

    private EstatusInfotec estatusInfotec;

    private Cursos cursos;

    private DatosPersonales datosPersonales;
}
