package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Carreras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepostory extends JpaRepository<Carreras, Long> {
}
