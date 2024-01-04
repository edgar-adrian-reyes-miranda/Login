package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosIngresos;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
public class HorariosDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String horario;
    private List<DatosIngresos> datosIngresos;
}
