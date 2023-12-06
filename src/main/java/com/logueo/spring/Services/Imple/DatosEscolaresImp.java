package com.logueo.spring.Services.Imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logueo.spring.Entity.Carreras;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Entity.Universidades;
import com.logueo.spring.Repository.DatosEscolaresRepository;
import com.logueo.spring.Services.DatosEscolaresServices;

@Service
public class DatosEscolaresImp implements DatosEscolaresServices{
	@Autowired
	private DatosEscolaresRepository datosEscolaresRepository;

	@Override
	public DatosEscolares guardar(DatosEscolares correo_inst) throws Exception {
		if(correo_inst.getCorreo_inst()== null) {
			throw new Exception("el dato puede ser nuevo");
		}
		return datosEscolaresRepository.save(correo_inst);
	}

	@Override
	public DatosEscolares obtenerEscolaresporId(Integer id) {
		Optional<DatosEscolares> optional=datosEscolaresRepository.findById(null);
		return optional.orElse(null);
	}

	@Override
	public void eliminardatopersonal(Integer id_datopersonal) {
		datosEscolaresRepository.deleteById(id_datopersonal);
		
	}

	@Override
	public List<DatosEscolares> findByCarrera(Carreras carreras) {
		
		return datosEscolaresRepository.findByCarrera(carreras);
	}

	@Override
	public List<DatosEscolares> findByUniversidades(Universidades universidades) {
		return datosEscolaresRepository.findByUniversidades(universidades);
	}
	

}
