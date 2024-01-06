package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;
import com.logueo.spring.Entity.DatosFTD;
import lombok.*;
@Data
public class ModalidadesEscolaresDto implements Serializable {
    	
	private static final long serialVersionUID=1L;
    private String tipo_modalidad;
   private List<DatosFTD> datosFTDS;
}
