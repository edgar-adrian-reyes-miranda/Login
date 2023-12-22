package com.logueo.spring.DTO;

import java.io.Serializable;
import lombok.*;
@Data
public class DatosIngresosDto implements Serializable {
    private static final long SerialVersionUID=1L;
    private String cv;
    private String historial_Academico;
}
