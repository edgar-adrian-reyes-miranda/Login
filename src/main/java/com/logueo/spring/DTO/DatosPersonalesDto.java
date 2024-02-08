package com.logueo.spring.DTO;

import com.logueo.spring.Entity.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.*;

import java.io.Serializable;
@Data
public class DatosPersonalesDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String nombre;
    private String p_apellido;
    private String s_apellido;
    //@Size(max=18, message = "EL numero de caracteres de CURP son 18")
    private String curp;
    private String direccion;
    private String estados;
    private String municipio;
    private Integer edad;
   // @Digits(integer=10, fraction = 0, message ="El maximo de numero de digitos son 10" )
    private Long telefono;
   // @Digits(integer=10, fraction = 0, message = "El maximo de numero son 10 digitos")
    private Long telefono_casa;
    private String correo;

    private Genero genero;

    private List<DatosEscolares> datosEscolares;

    private List<DatosIngresos> ingresos;

    private List<DatosFTD> datosFTD;

    private Usuario usuario;

}
