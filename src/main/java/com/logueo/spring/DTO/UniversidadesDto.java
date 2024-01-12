package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosEscolares;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UniversidadesDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;
    private List<DatosEscolares> datosEscolares;
}
