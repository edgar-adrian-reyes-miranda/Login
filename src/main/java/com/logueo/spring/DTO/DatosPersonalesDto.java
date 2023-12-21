package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.Usuario;
import lombok.*;
@Data
public class DatosPersonalesDto implements Serializable {

    private static final long SerialVersionUID=1L;
    private String nombre;
    private String P_apellido;
    private String S_apellido;
    private int telefono;
    private int telefonocasa;
    private String Genero;
    private String curp;
    private List<DatosFTD> datosFTDs;
    private List<Usuario> usuario;

}
