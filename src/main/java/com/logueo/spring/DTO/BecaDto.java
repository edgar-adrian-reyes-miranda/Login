package com.logueo.spring.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BecaDto implements Serializable {
    private static final long SerialVersionUID=1L;
    private String nombre_beca;
    private String Monto;
    private List<DocumentoBeca> documentoBecas;
    private List<DatosFTD> datosFTDs;
}
