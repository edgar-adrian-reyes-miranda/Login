package com.logueo.spring.DTO;
import com.logueo.spring.Entity.DatosFTD;
import com.logueo.spring.Entity.Unidad;
import lombok.*;
import java.io.Serializable;
@Data
public class CursosDto implements  Serializable{
    /**
     *
     *
     */
    private static  final long serialVersionUID= 1L;
    private String nombre;
    private Unidad unidades;
    private DatosFTD datosFTD;

}
