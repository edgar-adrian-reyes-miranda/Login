package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosFTD;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class TutoresDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;

    private List<DatosFTD> datosFTDS;
}
