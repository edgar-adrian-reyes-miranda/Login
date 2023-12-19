package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosFTD;
import java.io.Serializable;
import java.util.List;
import lombok.*;
@Data
public class ProyectosDto implements Serializable {

    private static final long SerialVersionUID= 1L;
    private String nombre;
    private String avance;
    private int evaluacion;

    private List<DatosFTD> datosFTDS;
}
