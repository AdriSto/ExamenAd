package com.adr.ad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adr.ad.dto.EstudianteDTO;
import com.adr.ad.exception.RecursoNoEncontrado;
import com.adr.ad.model.Estudiante;
import com.adr.ad.repository.EstudianteRepository;

@Service
public class EstudianteServiceIMP implements EstudianteServiceI {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public EstudianteDTO creaEstudiante(EstudianteDTO estudianteDTO) {
		Estudiante estudiante = mappeaDTOEstudiante(estudianteDTO);
		Estudiante estudianteRes = estudianteRepository.save(estudiante);
		EstudianteDTO estudianteDTORes = mapeaEstudianteDTO(estudianteRes);

		return estudianteDTORes;
	}

	@Override
	public List<EstudianteDTO> consultaEstudiante() {
		List<Estudiante> lestudiante = estudianteRepository.findAll();

		return lestudiante.stream().map(estudiante -> mapeaEstudianteDTO(estudiante)).collect(Collectors.toList());

	}

	@Override
	public EstudianteDTO consultaEstudianteID(Long id) {
		Estudiante estudiante = estudianteRepository.findById(id)
				.orElseThrow(() -> new RecursoNoEncontrado("ESTUDIANTE", "ID", id));
		return mapeaEstudianteDTO(estudiante);
	}

	private EstudianteDTO mapeaEstudianteDTO(Estudiante estudiante) {

		EstudianteDTO estudianteDTO = new EstudianteDTO();
		estudianteDTO.setCiudad(estudiante.getCiudad());
		estudianteDTO.setEdad(estudiante.getEdad());
		estudianteDTO.setId(estudiante.getId());
		estudianteDTO.setNombre(estudiante.getNombre());
		estudianteDTO.setZonaHoraria(estudiante.getZona_Horaria());

		return estudianteDTO;
	}

	private Estudiante mappeaDTOEstudiante(EstudianteDTO estudianteDTO) {
		Estudiante estudiante = new Estudiante();
		estudiante.setCiudad(estudianteDTO.getCiudad());
		estudiante.setEdad(estudianteDTO.getEdad());
		estudiante.setNombre(estudianteDTO.getNombre());
		estudiante.setZona_Horaria(estudianteDTO.getZonaHoraria());

		return estudiante;
	}

}
