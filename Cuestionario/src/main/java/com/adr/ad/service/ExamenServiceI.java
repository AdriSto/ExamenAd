package com.adr.ad.service;

import java.util.List;

import com.adr.ad.dto.ExamenDTO;

public interface ExamenServiceI {
	
	public ExamenDTO crearExamen(ExamenDTO examenDTO);
	
	public List<ExamenDTO> obtenerExamen();
	
	public ExamenDTO obtieneExamenID (long id) ;
	
	
	public ExamenDTO actualizarExamen (ExamenDTO examentDTO, long id);
	
	public ExamenDTO eliminarExamen (long id);

}
