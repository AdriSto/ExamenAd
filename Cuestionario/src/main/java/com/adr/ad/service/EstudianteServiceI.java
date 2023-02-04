package com.adr.ad.service;

import java.util.List;
import com.adr.ad.dto.EstudianteDTO;

public interface EstudianteServiceI {

	public EstudianteDTO creaEstudiante(EstudianteDTO estudianteDTO);
	public List<EstudianteDTO> consultaEstudiante();
	public EstudianteDTO consultaEstudianteID(Long id);
}
