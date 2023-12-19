package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosFTD;
import java.io.Serializable;
import java.util.List;
import lombok.*;
@Data
public class EnlaceDto implements Serializable {

    private static  final long SerialVersionUID=1l;
    private String tipo_enlace;
    private List<DatosFTD> datosFTDS;
}
