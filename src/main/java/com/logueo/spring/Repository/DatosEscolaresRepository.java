package com.logueo.spring.Repository;

import com.logueo.spring.Entity.DatosEscolares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosEscolaresRepository extends JpaRepository<DatosEscolares,Long> {
}
