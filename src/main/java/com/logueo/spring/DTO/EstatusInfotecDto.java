package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.DatosFTD;
import lombok.*;
@Data
public class EstatusInfotecDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String tipo_estatus;
    private List<DatosFTD> datosFTDS;
}
