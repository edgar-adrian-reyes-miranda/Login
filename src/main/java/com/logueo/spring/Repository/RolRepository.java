package com.logueo.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logueo.spring.Entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{

}
