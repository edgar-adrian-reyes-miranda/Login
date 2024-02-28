package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Universidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UniversidadRepository extends JpaRepository<Universidades, Long> {
   List<Universidades> findByActivoTrue();
   List<Universidades> findByActivoFalse();
}
