package com.logueo.spring.DTO;

import java.io.Serializable;
import lombok.*;
@Data
public class AdministradorDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String correo;
    private String password;
}
