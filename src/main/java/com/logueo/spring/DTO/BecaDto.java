package com.logueo.spring.DTO;

import lombok.Data;
import java.io.Serializable;


@Data
public class BecaDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;
    private String documento;
    private String pago;
    private String cuenta;
}
