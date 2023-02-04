package com.adr.ad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "zona_Horaria")
	private String zona_Horaria;
    
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEdad() {
		return edad;
	}



	public void setEdad(String edad) {
		this.edad = edad;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	



	public String getZona_Horaria() {
		return zona_Horaria;
	}



	public void setZona_Horaria(String zona_Horaria) {
		this.zona_Horaria = zona_Horaria;
	}



	public Estudiante( String nombre, String edad, String ciudad, String zonaHoraria) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.zona_Horaria = zonaHoraria;
	}



	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", ciudad=" + ciudad
				+ ", zona_Horaria=" + zona_Horaria + "]";
	}



	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
