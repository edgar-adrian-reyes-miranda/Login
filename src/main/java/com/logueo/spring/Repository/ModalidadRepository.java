package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Modalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad,Long> {
}
