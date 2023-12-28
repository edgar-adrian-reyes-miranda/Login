package com.logueo.spring.DTO;

import java.io.Serializable;
import lombok.*;
@Data
public class PerfilamientoDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;
    /*@Column(name="activo")
    private boolean activo=true;*/
}
