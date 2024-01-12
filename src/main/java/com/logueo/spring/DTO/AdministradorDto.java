package com.logueo.spring.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class AdministradorDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String correo;
    private String password;
}
