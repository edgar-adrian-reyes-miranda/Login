package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupos,Long> {
}
