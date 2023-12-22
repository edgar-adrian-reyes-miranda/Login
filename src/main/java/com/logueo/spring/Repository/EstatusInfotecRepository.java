package com.logueo.spring.Repository;

import com.logueo.spring.Entity.EstatusInfotec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatusInfotecRepository extends JpaRepository<EstatusInfotec, Long> {
}
