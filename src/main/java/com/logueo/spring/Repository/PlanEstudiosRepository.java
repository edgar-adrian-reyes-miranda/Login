package com.logueo.spring.Repository;

import com.logueo.spring.Entity.PlanEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEstudiosRepository extends JpaRepository<PlanEducativo,Long> {
    @Modifying
    @Query("UPDATE PlanEducativo p SET p.deleted = false WHERE p.id_plan = :id")
    void restorePlanEducativo(@Param("id") Long id);

}
