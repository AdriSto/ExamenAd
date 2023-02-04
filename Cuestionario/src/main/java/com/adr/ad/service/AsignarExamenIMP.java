package com.adr.ad.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adr.ad.dto.AsignarExamenDTO;
import com.adr.ad.exception.RecursoNoEncontrado;
import com.adr.ad.model.AsignarExamen;
import com.adr.ad.model.Estudiante;
import com.adr.ad.repository.AsignarExamRespository;
import com.adr.ad.repository.EstudianteRepository;

@Service
public class AsignarExamenIMP implements AsignarExamenI {

	@Autowired
	private AsignarExamRespository asignarExamenRepository;
	
	@Autowired
	private EstudianteRepository  estudianteRepository;

	@Override
	public AsignarExamenDTO asingarExamen(AsignarExamenDTO asignarExamenDTO, long idEstudiante) {	
		
		Estudiante estidianteValida =  estudianteRepository.findById(idEstudiante).orElseThrow(() -> new RecursoNoEncontrado("ESTUDIANTE", "ID", idEstudiante));
		
		asignarExamenDTO.setZonaHorariaExamen(String.valueOf(ZonedDateTime.now().getZone()));	
		asignarExamenDTO.setIdEstudiante(estidianteValida.getId());
		     
		
		
		AsignarExamen asignarExamen = mapeaAsinarExamenEntidad(asignarExamenDTO);		
		AsignarExamen asignarExamenRes = asignarExamenRepository.save(asignarExamen);		
		AsignarExamenDTO asignarExamenDTORes = mappeaAsignarExamenDTO(asignarExamenRes);

		return asignarExamenDTORes;
	}

	@Override
	public AsignarExamenDTO consultaExamenEstudiante(long id) {
		AsignarExamen asignarExamen = asignarExamenRepository.findById(id).orElseThrow(() -> new RecursoNoEncontrado("ASINGAR EXAMEN", "ID", id));
		return mappeaAsignarExamenDTO(asignarExamen);
	}

	private AsignarExamenDTO mappeaAsignarExamenDTO(AsignarExamen asignarExamen) {
		SimpleDateFormat formateadorFecha = new SimpleDateFormat("YYY-MM-dd");
		AsignarExamenDTO examenDTO = new AsignarExamenDTO();
		examenDTO.setId(asignarExamen.getId());
		examenDTO.setExamenAsingado(asignarExamen.getExamen_asignado());
		examenDTO.setFechaExamen(asignarExamen.getFecha_examen());
		examenDTO.setHoraExamen(asignarExamen.getHora_examen());
		examenDTO.setIdEstudiante(asignarExamen.getId_estudiante());
		examenDTO.setZonaHorariaExamen(asignarExamen.getZona_horaria());

		return examenDTO;

	}

	private AsignarExamen mapeaAsinarExamenEntidad(AsignarExamenDTO asignarExamenDTO) {
		AsignarExamen examenAsignado = new AsignarExamen();
		//examenAsignado.setId(0);
		examenAsignado.setExamen_asignado(asignarExamenDTO.getExamenAsingado());
		examenAsignado.setFecha_examen(asignarExamenDTO.getFechaExamen());
		examenAsignado.setHora_examen(asignarExamenDTO.getHoraExamen());
		examenAsignado.setId_estudiante(asignarExamenDTO.getIdEstudiante());
		examenAsignado.setZona_horaria(asignarExamenDTO.getZonaHorariaExamen());

		return examenAsignado;
	}
	
	

}
