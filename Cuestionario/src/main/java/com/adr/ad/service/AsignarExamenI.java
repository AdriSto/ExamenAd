package com.adr.ad.service;

import java.util.List;

import com.adr.ad.dto.AsignarExamenDTO;

public interface AsignarExamenI {
	
    public AsignarExamenDTO asingarExamen(AsignarExamenDTO asignarExamenDTO, long idEstudiante);
    public AsignarExamenDTO consultaExamenEstudiante(long id);
    
}
