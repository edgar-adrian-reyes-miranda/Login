package com.logueo.spring.DTO;
import com.logueo.spring.Entity.DatosFTD;
import com.logueo.spring.Entity.Unidad;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Data
public class CursosDto implements  Serializable{

    private static  final long serialVersionUID= 1L;
    private String nombre;
        private List<Unidad> unidades;
    private List<DatosFTD> datosFTDS;

}
