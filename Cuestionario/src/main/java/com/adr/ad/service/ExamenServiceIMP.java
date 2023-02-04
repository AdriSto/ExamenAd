package com.adr.ad.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adr.ad.dto.ExamenDTO;
import com.adr.ad.exception.RecursoNoEncontrado;
import com.adr.ad.model.Examen;
import com.adr.ad.repository.ExamenRepository;

@Service
public class ExamenServiceIMP implements ExamenServiceI {

	@Autowired
	private ExamenRepository examenRepository;

	@Override
	public ExamenDTO crearExamen(ExamenDTO examenDTO) {
		Examen examen = mappearEntidadExamen(examenDTO);
		Examen examenRes = examenRepository.save(examen);
		ExamenDTO examenDTORes = mapearExamenDTO(examenRes);
		return examenDTORes;
	}

	@Override
	public List<ExamenDTO> obtenerExamen() {
		List<Examen> lexamen = examenRepository.findAll();

		return lexamen.stream().map(examen -> mapearExamenDTO(examen)).collect(Collectors.toList());
	}

	@Override
	public ExamenDTO obtieneExamenID(long id) {
		Examen examen = examenRepository.findById(id)
				.orElseThrow(() -> new RecursoNoEncontrado("EXAMEN", "ID", id));

		return mapearExamenDTO(examen);
	}
	
	
	
	@Override
	public ExamenDTO actualizarExamen(ExamenDTO examenDTO, long id) {
		Examen examen = examenRepository.findById(id)
				.orElseThrow(() -> new RecursoNoEncontrado("EXAMEN", "ID", id));
		
		examen.setPregunta(examenDTO.getPregunta());
		examen.setOpcion_A(examenDTO.getOpcionA());
		examen.setOpcion_B(examenDTO.getOpcionB());
		examen.setOpcion_C(examenDTO.getOpcionC());
		examen.setOpcion_D(examenDTO.getOpcionD());
		examen.setOpcion_correcta(examenDTO.getOpcionCorrecta());
		
		Examen examenActualizado = examenRepository.save(examen);
		
		return mapearExamenDTO(examenActualizado);
	}
	
	
	@Override
	public ExamenDTO eliminarExamen(long id) {
		Examen examen = examenRepository.findById(id)
				.orElseThrow(() -> new RecursoNoEncontrado("EXAMEN", "ID", id));
		
		//Examen examenEliminado = examenRepository
		return null;
	}
	
	

	private ExamenDTO mapearExamenDTO(Examen examen) {
		ExamenDTO examenDTO = new ExamenDTO();
		examenDTO.setId(examen.getId());
		examenDTO.setPregunta(examen.getPregunta());
		examenDTO.setOpcionA(examen.getOpcion_A());
		examenDTO.setOpcionB(examen.getOpcion_B());
		examenDTO.setOpcionC(examen.getOpcion_C());
		examenDTO.setOpcionD(examen.getOpcion_D());
		examenDTO.setOpcionCorrecta(examen.getOpcion_correcta());

		return examenDTO;

	}

	private Examen mappearEntidadExamen(ExamenDTO examenDTO) {
		Examen examen = new Examen();
		examen.setPregunta(examenDTO.getPregunta());
		examen.setOpcion_A(examenDTO.getOpcionA());
		examen.setOpcion_B(examenDTO.getOpcionB());
		examen.setOpcion_C(examenDTO.getOpcionC());
		examen.setOpcion_D(examenDTO.getOpcionD());
		examen.setOpcion_correcta(examenDTO.getOpcionCorrecta());

		return examen;

	}

	

	

}
