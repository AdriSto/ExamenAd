package com.adr.ad.dto;

import lombok.Data;

@Data
public class EstudianteDTO {
	
	private Long id;
	private String nombre;
	private String edad;
	private String ciudad;
	private String zonaHoraria;
	
	
	public EstudianteDTO(Long id, String nombre, String edad, String ciudad, String zonaHoraria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.zonaHoraria = zonaHoraria;
	}


	public EstudianteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
