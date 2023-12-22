package com.logueo.spring.Repository;

import com.logueo.spring.Entity.ModalidadesEscolares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadesEscolaresRepository extends JpaRepository<ModalidadesEscolares, Long> {
}
