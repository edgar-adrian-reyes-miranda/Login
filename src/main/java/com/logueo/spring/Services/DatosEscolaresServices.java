package com.logueo.spring.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logueo.spring.Entity.Carreras;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Entity.ModalidadesEscolares;
import com.logueo.spring.Entity.Periodo;
import com.logueo.spring.Entity.PlanEstudios;
import com.logueo.spring.Entity.Universidades;

@Service
public interface DatosEscolaresServices {
	public DatosEscolares guardar(DatosEscolares correo_inst)throws Exception;
	public DatosEscolares obtenerEscolaresporId(Integer id);
	public void eliminardatopersonal(Integer id_datopersonal);
	List<DatosEscolares>findByCarrera(Carreras carreras);
	List<DatosEscolares>findByUniversidades(Universidades universidades);
	List<DatosEscolares>findByPeriodo(Periodo periodo);
	List<DatosEscolares>findByModaliadesEscolares(ModalidadesEscolares modalidadesEscolares);
	List<DatosEscolares>findByPlanEstudios(PlanEstudios planEstudios);
}
