package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.*;
import lombok.*;
@Data
public class DatosEscolaresDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String matricula;
    private String correo_inst;
    private String carrera;
    private List<DatosPersonales> datosPersonales;
    private Periodo periodo;
    private Universidades universidades;
    private PlanEducativo planEducativo;
    private ModalidadesEscolares modalidadesEscolares;
}
