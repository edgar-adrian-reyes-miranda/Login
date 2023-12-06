package com.logueo.spring.Services.Imple;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logueo.spring.Entity.Datospersonales;
import com.logueo.spring.Repository.DatosPersonalesRepository;
import com.logueo.spring.Services.DatosPersonalesServices;
import lombok.Data;

@Data
@Service
public class DatosPersonalesImp implements DatosPersonalesServices{
	@Autowired
	private DatosPersonalesRepository datosPersonalesRepository;
	
	@Override
	public Datospersonales obtenerUsuarioporId(Integer id) {
		Optional<Datospersonales> daOptional= datosPersonalesRepository.findById(null);
		return daOptional.orElse(null);
	}

	@Override
	public void eliminardatopersonal(Integer id_datopersonal) {
		datosPersonalesRepository.deleteById(id_datopersonal);
		
	}

	@Override
	public Datospersonales guardar(Datospersonales nomnbre) throws Exception {
               if (nomnbre.getNombre() == null) {
            throw new Exception("El nombre no puede ser nulo");
        }

        // Guardar en la base de datos
        return datosPersonalesRepository.save(nomnbre);
    }
}
