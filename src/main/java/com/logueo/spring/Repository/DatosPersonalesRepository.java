package com.logueo.spring.Repository;

import com.logueo.spring.Entity.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, Long> {
}
