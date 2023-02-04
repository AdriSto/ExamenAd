package com.adr.ad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "respuestasExamenEstudiante")
public class RespuestasPreguntas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "id_estudiante")
	private long id_estudiante;
	
	@Column(name = "respuesta_pregunta1")
	private String respuesta_pregunta1;
	
	@Column(name = "respuesta_pregunta2")
	private String respuesta_pregunta2;
	
	@Column(name = "respuesta_pregunta3")
	private String respuesta_pregunta3;
	
	@Column(name = "respuesta_pregunta4")
	private String respuesta_pregunta4;
	
	@Column(name = "porcentaje_obtenido")
	private String porcentaje_obtenido;
	
	@Column(name = "resultado_examen")
	private String resultado_examen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public long getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(long id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getRespuesta_pregunta1() {
		return respuesta_pregunta1;
	}

	public void setRespuesta_pregunta1(String respuesta_pregunta1) {
		this.respuesta_pregunta1 = respuesta_pregunta1;
	}

	public String getRespuesta_pregunta2() {
		return respuesta_pregunta2;
	}

	public void setRespuesta_pregunta2(String respuesta_pregunta2) {
		this.respuesta_pregunta2 = respuesta_pregunta2;
	}

	public String getRespuesta_pregunta3() {
		return respuesta_pregunta3;
	}

	public void setRespuesta_pregunta3(String respuesta_pregunta3) {
		this.respuesta_pregunta3 = respuesta_pregunta3;
	}

	public String getRespuesta_pregunta4() {
		return respuesta_pregunta4;
	}

	public void setRespuesta_pregunta4(String respuesta_pregunta4) {
		this.respuesta_pregunta4 = respuesta_pregunta4;
	}

	public String getPorcentaje_obtenido() {
		return porcentaje_obtenido;
	}

	public void setPorcentaje_obtenido(String porcentaje_obtenido) {
		this.porcentaje_obtenido = porcentaje_obtenido;
	}

	public String getResultado_examen() {
		return resultado_examen;
	}

	public void setResultado_examen(String resultado_examen) {
		this.resultado_examen = resultado_examen;
	}
	

	@Override
	public String toString() {
		return "RespuestasPreguntas [id=" + id + ", id_estudiante=" + id_estudiante + ", respuesta_pregunta1="
				+ respuesta_pregunta1 + ", respuesta_pregunta2=" + respuesta_pregunta2 + ", respuesta_pregunta3="
				+ respuesta_pregunta3 + ", respuesta_pregunta4=" + respuesta_pregunta4 + ", porcentaje_obtenido="
				+ porcentaje_obtenido + ", resultado_examen=" + resultado_examen + "]";
	}

	
	
	

}
