package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.DatosFTD;
import lombok.*;
@Data
public class EnlaceDto implements Serializable {

    private static  final long serialVersionUID=1L;
    private String tipo_enlace;
     private List<DatosFTD> datosFTD;

}
