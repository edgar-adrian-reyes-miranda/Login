package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.Date;
import lombok.*;
@Data
public class DatosFTDDto implements Serializable {

    private static final long SerialVersionUID=1L;
    private String area;
    private Date fecha_ingreso;
    private Date fecha_termino;
    private String correo_becario;
    private int matricula_ftd;

}
