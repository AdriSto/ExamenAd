package com.adr.ad.dto;

import lombok.Data;

@Data
public class ExamenDTO {
	
	private Long id;
	private String pregunta;
	private String opcionA;
	private String opcionB;
	private String opcionC;
	private String opcionD;
	private String opcionCorrecta;
	
	
	public ExamenDTO(Long id, String pregunta, String opcionA, String opcionB, String opcionC, String opcionD,
			String opcionCorrecta) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.opcionA = opcionA;
		this.opcionB = opcionB;
		this.opcionC = opcionC;
		this.opcionD = opcionD;
		this.opcionCorrecta = opcionCorrecta;
	}


	public ExamenDTO() {
		super();
	}
	
	
	
	

}
