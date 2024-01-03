package com.logueo.spring.DTO;

import java.io.Serializable;

import com.logueo.spring.Entity.DatosPersonales;
import com.logueo.spring.Entity.Tramite;
import jakarta.persistence.ManyToOne;
import lombok.*;
@Data
public class DatosIngresosDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String cv;
    private String historial_Academico;
    @ManyToOne
    private Tramite tramite;
    private DatosPersonales datosPersonales;
}
