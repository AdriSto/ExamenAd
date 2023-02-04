package com.adr.ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adr.ad.dto.AsignarExamenDTO;
import com.adr.ad.dto.EstudianteDTO;
import com.adr.ad.dto.ExamenDTO;
import com.adr.ad.dto.RespuestasPreguntasDTO;
import com.adr.ad.repository.AsignarExamRespository;
import com.adr.ad.service.AsignarExamenI;
import com.adr.ad.service.EstudianteServiceI;
import com.adr.ad.service.ExamenServiceI;
import com.adr.ad.service.RecopilarRespuestasI;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/examen", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ExamenController {

	@Autowired
	private ExamenServiceI examenServiceI;
	
	@Autowired
	private EstudianteServiceI estudianteServiceI;
	
	@Autowired
	private AsignarExamenI asignarExamenI;
	
	@Autowired	
	private RecopilarRespuestasI recopilarRespuestasI;

	@PostMapping("/creaExamen")
	public ResponseEntity<ExamenDTO> crearExamen(@RequestBody ExamenDTO examenDTO) {

		return new ResponseEntity<>(examenServiceI.crearExamen(examenDTO), HttpStatus.CREATED);

	}

	@GetMapping("listaExamen")
	public List<ExamenDTO> obtieneExamen() {
		return examenServiceI.obtenerExamen();
	}
	
	@GetMapping("examenID/{id}")
	public ResponseEntity<ExamenDTO> consultaExamenID(@PathVariable(name="id") long id) {
		return ResponseEntity.ok(examenServiceI.obtieneExamenID(id));
		
	}
	
	@PostMapping("creaEstudiante")
	public ResponseEntity<EstudianteDTO> creaEstudiante(@RequestBody EstudianteDTO  estudianteDTO){		
		return new ResponseEntity<>(estudianteServiceI.creaEstudiante(estudianteDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("listaEstudiantes")
	public List<EstudianteDTO> listaEstudianteId(){
		return estudianteServiceI.consultaEstudiante();
	}
	
	@GetMapping("consultaEstidianteId/{id}")
	public ResponseEntity<EstudianteDTO> consultaEstudianteId(@PathVariable(name="id") long id){
		return ResponseEntity.ok(estudianteServiceI.consultaEstudianteID(id));
	}
	
	@PostMapping("asginarExamenEstudiante/{id}")
	public ResponseEntity<AsignarExamenDTO> asignarExamenEstudiante(@RequestBody AsignarExamenDTO asignarExamenDTO, @PathVariable(name="id") long idEstudiante ){
		return new ResponseEntity<>(asignarExamenI.asingarExamen(asignarExamenDTO, idEstudiante), HttpStatus.CREATED);
	}
	
	@GetMapping("consultaExamenEstudiante/{id}")
	public ResponseEntity<AsignarExamenDTO> consultaExamenEstudiante(@PathVariable(name="id") long id){
		return  ResponseEntity.ok(asignarExamenI.consultaExamenEstudiante(id));
	}
	
	@PostMapping("recopilaRespuestasEstudiante/{id}")
	public ResponseEntity<RespuestasPreguntasDTO> recopilaRespuestasEstudiante(@RequestBody RespuestasPreguntasDTO respuestasPreguntasDTO, @PathVariable(name="id") long idEstudiante ){
		return new ResponseEntity<>(recopilarRespuestasI.recopilaRespuestasDTO(respuestasPreguntasDTO, idEstudiante), HttpStatus.CREATED);
	}
	
	/*@PutMapping("actualizaExamen/{id}")
	public ResponseEntity<ExamenDTO> actualizaExamen(@RequestBody ExamenDTO examenDTO, @PathVariable(name="id") long id){
		ExamenDTO examenDTOResultado = examenServiceI.actualizarExamen(examenDTO, id);
		return new ResponseEntity<>(examenDTOResultado, HttpStatus.OK);
	}*/

}
