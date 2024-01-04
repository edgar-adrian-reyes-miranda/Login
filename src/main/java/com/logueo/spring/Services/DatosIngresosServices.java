package com.logueo.spring.Services;

import com.logueo.spring.DTO.DatosIngresosDto;
import com.logueo.spring.Entity.DatosIngresos;
import com.logueo.spring.Repository.DatosIngresosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatosIngresosServices {
    @Autowired
    private DatosIngresosRepository datosIngresosRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<DatosIngresos> findAllingreso(){
        return datosIngresosRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public DatosIngresos findByIdDatosIngresos(Long id) {
        return datosIngresosRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public DatosIngresos crearDatosIngresos(DatosIngresosDto DatosIngresosDto) {
        DatosIngresos DatosIngresoss= new DatosIngresos ();
        DatosIngresoss.setCv(DatosIngresosDto.getCv());
        DatosIngresoss.setHistorial_Academico(DatosIngresosDto.getHistorial_Academico());
        DatosIngresoss.setDatosPersonales(DatosIngresosDto.getDatosPersonales());
        DatosIngresoss.setTramite(DatosIngresosDto.getTramite());
        DatosIngresoss.setPerfilamiento(DatosIngresosDto.getPerfilamiento());
        DatosIngresoss.setHorarios(DatosIngresosDto.getHorarios());
        return datosIngresosRepository.save(DatosIngresoss);
    }

    //Eliminar
    @Transactional
    public void eliminarDatosIngresos(Long id) {
        datosIngresosRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public DatosIngresos editarDatosIngresos(Long id, DatosIngresosDto DatosIngresosDto) {
        DatosIngresos DatosIngresos = datosIngresosRepository.findById(id).orElse(null);
        if(DatosIngresos != null) {
          DatosIngresos.setCv(DatosIngresosDto.getCv());
          DatosIngresos.setHistorial_Academico(DatosIngresosDto.getHistorial_Academico());
          DatosIngresos.setTramite(DatosIngresosDto.getTramite());
          DatosIngresos.setDatosPersonales(DatosIngresosDto.getDatosPersonales());
          DatosIngresos.setPerfilamiento(DatosIngresosDto.getPerfilamiento());
          DatosIngresos.setHorarios(DatosIngresosDto.getHorarios());
            return datosIngresosRepository.save(DatosIngresos);
        }else {
            return null;
        }
    }
}
