package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.logueo.spring.Entity.*;
import lombok.*;
@Data
public class DatosFTDDto implements Serializable {

    private static final long SerialVersionUID=1L;
    private String area;
    private String tutor;
    private Date fecha_inicio;
    private Date fecha_final;
    private String correo_becario;
    private int matricula;
    private List<Proyectos> proyectos;
    private List<Cursos>  cursos;
    private Grupo grupo;
    private Enlace enlace;
    private List<EstausInfotec> estausInfotecs;
    private Beca beca;
    private List<Datospersonales> datospersonales;

}
