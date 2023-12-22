package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Universidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidades, Long> {
}
