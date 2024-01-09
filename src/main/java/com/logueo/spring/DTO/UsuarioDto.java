package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Entity.DatosPersonales;
import lombok.*;

@Data
public class UsuarioDto implements Serializable{
	
	private static final long serialVersionUID=1L;
	private String username;
	private String password;
	private String correo;
	private List<DatosPersonales> datosPersonales;

}
