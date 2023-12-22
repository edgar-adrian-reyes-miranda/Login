package com.logueo.spring.DTO;

import java.io.Serializable;
import lombok.*;
@Data
public class DatosEscolaresDto implements Serializable {
    private static final long SerialVersionUID=1L;
    private int matricula;
    private String correo_inst;
}
