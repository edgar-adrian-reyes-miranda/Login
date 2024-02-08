package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosPersonales;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data

public class GeneroDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String tipo_genero;
    private List<DatosPersonales> datosPersonales;
}
