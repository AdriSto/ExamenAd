package com.adr.ad.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "examen", uniqueConstraints = {@UniqueConstraint(columnNames = "pregunta")})
public class Examen {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "pregunta", nullable = false)
	private String pregunta;
	
	@Column(name = "opcion_A", nullable = false)
	private String opcion_A;

	
	@Column(name = "opcion_B", nullable = false)	
	private String opcion_B;
	

	@Column(name = "opcion_C", nullable = false)	
	private String opcion_C;
	
	
	@Column(name = "opcion_D", nullable = false)
	private String opcion_D;
	
	
	@Column(name = "opcion_correcta", nullable = false)
	private String opcion_correcta;
	
	
	public Examen( String pregunta, String opcionA, String opcionB, String opcionC, String opcionD,
			String opcionCorrecta) {
		super();
		this.pregunta = pregunta;
		this.opcion_A = opcionA;
		this.opcion_B = opcionB;
		this.opcion_C = opcionC;
		this.opcion_D = opcionD;
		this.opcion_correcta = opcionCorrecta;
	}



	public Examen() {
		
	}



	@Override
	public String toString() {
		return "Examen [id=" + id + ", pregunta=" + pregunta + ", opcion_A=" + opcion_A + ", opcion_B=" + opcion_B + ", opcion_C=" + opcion_C +", opcion_D=" + opcion_D +", opcion_correcta=" + opcion_correcta + "]";
	}
}
