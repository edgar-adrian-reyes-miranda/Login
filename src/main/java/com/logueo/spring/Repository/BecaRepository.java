package com.logueo.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BecaRepository extends JpaRepository<Beca , Long> {
}
