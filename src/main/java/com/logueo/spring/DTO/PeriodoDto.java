package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Entity.Periodo;
import lombok.*;
@Data
public class PeriodoDto implements Serializable {
    private static final long serialVersionUID=1L;
    private String tipo_periodo;
    private List<DatosEscolares> escolares;
}
