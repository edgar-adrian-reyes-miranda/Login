package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosPersonales;
import com.logueo.spring.Entity.Horarios;
import com.logueo.spring.Entity.Perfilamiento;
import com.logueo.spring.Entity.Tramite;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class DatosIngresosDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String cv;
    private String historial_Academico;

    private Tramite tramite;
    private List<DatosPersonales> datosPersonales;
    private Perfilamiento perfilamiento;
    private Horarios horarios;
}
