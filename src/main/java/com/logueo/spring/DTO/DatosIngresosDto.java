package com.logueo.spring.DTO;

import com.logueo.spring.Entity.*;
import lombok.Data;
import java.io.Serializable;

@Data
public class DatosIngresosDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String cv;
    private String historial_Academico;
    private Tramite tramite;
    private Perfilamiento perfilamiento;
    private Horarios horarios;
    private Turno turno;
    private Modalidad modalidad;
    private DatosPersonales datosPersonales;
}
