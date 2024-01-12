package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProyectosReposotory extends JpaRepository<Proyectos, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Proyectos p SET p.status = false WHERE p.id_proyecto = :id_proyecto")
    void sofDeleteProyecto(@Param("id_proyecto") String id);


    @Transactional
    @Modifying
    @Query("UPDATE Proyectos p SET p.status = true WHERE p.id_proyecto = :id_proyecto")
    void restoreProyecto(@Param("id_proyecto") String id);


}
