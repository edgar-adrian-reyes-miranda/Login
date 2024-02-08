package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios,Long> {
}
