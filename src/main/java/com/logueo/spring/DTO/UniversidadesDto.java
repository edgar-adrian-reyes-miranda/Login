package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.DatosEscolares;
import lombok.*;
@Data
public class UniversidadesDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;
    private List<DatosEscolares> datosEscolares;
}
