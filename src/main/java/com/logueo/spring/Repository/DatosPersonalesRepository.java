package com.logueo.spring.Repository;

import com.logueo.spring.Entity.DatosPersonales;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, Long> {
	@EntityGraph(attributePaths = {"genero"})
    List<DatosPersonales> findAll();
}
