package com.logueo.spring.Services;

import com.logueo.spring.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServices {
     @Autowired
    private RolRepository rolRepository;
}
