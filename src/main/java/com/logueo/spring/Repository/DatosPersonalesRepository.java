package com.logueo.spring.Repository;

import com.logueo.spring.Entity.DatosPersonales;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, Long> {
	@EntityGraph(attributePaths = {"genero"})
    List<DatosPersonales> findAll();
}
