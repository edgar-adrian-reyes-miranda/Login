package com.logueo.spring.Repository;

import com.logueo.spring.Entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminsitradorRepository extends JpaRepository<Administrador,Long> {
    Administrador findByCorreo(String correo);

}
