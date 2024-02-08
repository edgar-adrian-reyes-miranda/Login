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

    private Turno turno;

    private Horarios horarios;

    private Modalidad modalidad;
    
    private DatosPersonales datosPersonales;
}
