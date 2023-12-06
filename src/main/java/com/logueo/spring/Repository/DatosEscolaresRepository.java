package com.logueo.spring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Entity.Universidades;
import com.logueo.spring.Entity.Carreras;


@Repository
public interface DatosEscolaresRepository extends JpaRepository<DatosEscolares, Integer>{
	public Optional<DatosEscolares>findById(Integer id);
	List<DatosEscolares>findByCarrera(Carreras carreras);
	List<DatosEscolares>findByUniversidades(Universidades universidad);
}
