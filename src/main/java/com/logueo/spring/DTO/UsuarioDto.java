package com.logueo.spring.DTO;

import com.logueo.spring.Entity.DatosPersonales;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UsuarioDto implements Serializable{
	
	private static final long serialVersionUID=1L;
	private String username;
	private String password;
	private String correo;
	private List<DatosPersonales> datosPersonales;

}
