package com.logueo.spring.Repository;

import com.logueo.spring.Entity.DatosIngresos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosIngresosRepository extends JpaRepository<DatosIngresos,Long> {
}
