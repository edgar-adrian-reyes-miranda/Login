package com.logueo.spring.Repository;

import com.logueo.spring.Entity.PlanEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEstudiosRepository extends JpaRepository<PlanEducativo,Long> {


}
