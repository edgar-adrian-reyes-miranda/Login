package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository <Unidad, Long>{
}
