package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Perfilamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilamientoRepositiry extends JpaRepository<Perfilamiento,Long> {
}
