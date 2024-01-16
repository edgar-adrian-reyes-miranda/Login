package com.logueo.spring.DTO;

import com.logueo.spring.Entity.*;
import lombok.Data;
import java.io.Serializable;

@Data
public class DatosEscolaresDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String matricula;
    private String correo_inst;
    private String carrera;
    private Periodo periodo;
    private Universidades universidades;
    private PlanEducativo planEducativo;
    private ModalidadesEscolares modalidadesEscolares;
    private DatosPersonales datosPersonales;
}
