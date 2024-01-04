package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.DatosIngresos;
import lombok.*;
@Data
public class PerfilamientoDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;
    private List<DatosIngresos> datosIngresos;
    /*@Column(name="activo")
    private boolean activo=true;*/
}
