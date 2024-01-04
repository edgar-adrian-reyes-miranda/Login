package com.logueo.spring.DTO;


import com.logueo.spring.Entity.DatosFTD;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.io.Serializable;
import java.util.List;


@Data
public class CursosDto implements  Serializable{

    private static  final long serialVersionUID= 1L;
    private String nombre;
    private String tipo_estatus;
    private String unidad;

    private List<DatosFTD> datosFTD;
}
