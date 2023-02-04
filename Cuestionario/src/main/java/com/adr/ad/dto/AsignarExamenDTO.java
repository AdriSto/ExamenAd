package com.adr.ad.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AsignarExamenDTO {
	
	private Long id;
	private Long idEstudiante;
	private Date fechaExamen;
	private String horaExamen;
	private String zonaHorariaExamen;
	private String examenAsingado;
	
	
	public AsignarExamenDTO(Long id, Long ideEstudiante, Date fechaExamen, String horaExamen, String zonaHorariaExamen,
			String examenAsingado) {
		super();
		this.id = id;
		this.idEstudiante = ideEstudiante;
		this.fechaExamen = fechaExamen;
		this.horaExamen = horaExamen;
		this.zonaHorariaExamen = zonaHorariaExamen;
		this.examenAsingado = examenAsingado;
	}


	public AsignarExamenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
