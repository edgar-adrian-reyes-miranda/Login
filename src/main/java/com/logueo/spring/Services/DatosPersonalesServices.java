package com.logueo.spring.Services;

import org.springframework.stereotype.Service;

import com.logueo.spring.Entity.Datospersonales;


@Service
public interface DatosPersonalesServices {
	public Datospersonales guardar(Datospersonales nombre)throws Exception;
	public Datospersonales obtenerUsuarioporId(Integer id);
	public void eliminardatopersonal(Integer id_datopersonal);

}
