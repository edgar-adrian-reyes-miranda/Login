package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Enlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnlaceRepository extends JpaRepository<Enlace , Long> {
}
