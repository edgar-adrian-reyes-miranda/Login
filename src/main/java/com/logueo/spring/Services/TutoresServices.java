package com.logueo.spring.Services;

import com.logueo.spring.Entity.Tutores;
import com.logueo.spring.Repository.TutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TutoresServices {
    @Autowired
    private TutoresRepository tutoresRepository;
    @Transactional(readOnly = true)
    public List<Tutores>findAllTurtor(){
        return tutoresRepository.findAll();
    }
}
