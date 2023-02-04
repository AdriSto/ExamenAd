package com.adr.ad.dto;

import lombok.Data;

@Data
public class RespuestasPreguntasDTO {
	
	private Long id;
	private Long idEstudiante;
	private String respuestaPregunta1;
	private String respuestaPregunta2;
	private String respuestaPregunta3;
	private String respuestaPregunta4;
	private String porcentajeObtenido;
	private String resultadoExamen;
	
	
	
	public RespuestasPreguntasDTO(Long id, Long idEstudiante, String respuestaPregunta1, String respuestaPregunta2,
			String respuestaPregunta3, String respuestaPregunta4, String porcentajeObtenido, String resultadoExamen) {
		super();
		this.id = id;
		this.idEstudiante = idEstudiante;
		this.respuestaPregunta1 = respuestaPregunta1;
		this.respuestaPregunta2 = respuestaPregunta2;
		this.respuestaPregunta3 = respuestaPregunta3;
		this.respuestaPregunta4 = respuestaPregunta4;
		this.porcentajeObtenido = porcentajeObtenido;
		this.resultadoExamen = resultadoExamen;
	}



	public RespuestasPreguntasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
