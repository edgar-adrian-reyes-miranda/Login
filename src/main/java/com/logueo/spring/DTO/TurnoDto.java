package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosIngresos;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TurnoDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String tipo_turno;
    private List<DatosIngresos> datosIngresos;
}
