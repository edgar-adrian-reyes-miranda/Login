package com.logueo.spring.DTO;

import java.io.Serializable;

import com.logueo.spring.Entity.DatosPersonales;
import lombok.*;
@Data
public class DatosEscolaresDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String matricula;
    private String correo_inst;
    private String carrera;
    private DatosPersonales datosPersonales;
}
