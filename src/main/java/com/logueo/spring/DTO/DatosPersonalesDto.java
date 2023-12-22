package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.DatosFTD;
import com.logueo.spring.Entity.Usuario;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
public class DatosPersonalesDto implements Serializable {

    private static final long SerialVersionUID=1L;
    private String nombre;
    private String p_apellido;
    private String s_apellido;
    @Size(max=18, message = "EL numero de caracteres de CURP son 18")
    private String curp;
    private String direccion;
    @Min(value = 0, message = "Ingrese su edad")
    private Integer edad;
    @Size(max=10, message ="El maximo de numero de digitos son 10" )
    private int telefono;
    @Size(max=10, message = "El maximo de numero son 10 digitos")
    private int telefono_casa;
    private String correo;

}
