package com.logueo.spring.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logueo.spring.Entity.Datospersonales;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<Datospersonales, Integer>{
	public Optional<Datospersonales>findById(Integer id);
		 
}
