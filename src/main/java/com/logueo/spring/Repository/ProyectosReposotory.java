package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosReposotory extends JpaRepository<Proyectos, Long> {
}
