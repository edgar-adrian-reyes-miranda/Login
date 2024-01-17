package com.logueo.spring.DTO;

import com.logueo.spring.Entity.*;
import lombok.Data;
import java.io.Serializable;

@Data
public class DatosEscolaresDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String correo_inst;
    private String carrera;
    private String matricula;

    private Universidades universidades;

    private ModalidadesEscolares modalidadesEscolares;

    private PlanEducativo planEducativo;

    private Periodo periodo;

    private DatosPersonales datosPersonales;
}
