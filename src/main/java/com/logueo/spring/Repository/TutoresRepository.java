package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Tutores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutoresRepository extends JpaRepository<Tutores,Long> {
}
