package com.logueo.spring.Repository;

import com.logueo.spring.Entity.DocumentoBeca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoBecaRepository extends JpaRepository<DocumentoBeca , Long> {
}
