package com.logueo.spring.DTO;

import java.io.Serializable;
import lombok.*;

@Data
public class TramiteDto implements Serializable {
    private static final long SerialVersionUID=1L;
    private String tipo_tramite;
}
