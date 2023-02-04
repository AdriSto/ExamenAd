package com.adr.ad.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adr.ad.dto.RespuestasPreguntasDTO;
import com.adr.ad.exception.RecursoNoEncontrado;
import com.adr.ad.model.Estudiante;
import com.adr.ad.model.Examen;
import com.adr.ad.model.RespuestasPreguntas;
import com.adr.ad.repository.EstudianteRepository;
import com.adr.ad.repository.ExamenRepository;
import com.adr.ad.repository.RecopilarRespuestasRepository;

@Service
public class RecopilarRespuestasIMP implements RecopilarRespuestasI {

	@Autowired
	private RecopilarRespuestasRepository recopilarRespuestasRepository;

	@Autowired
	private ExamenRepository examenRepository;

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public RespuestasPreguntasDTO recopilaRespuestasDTO(RespuestasPreguntasDTO respuestasPreguntasDTO, long id) {
		int porcentaje = 0;

		Estudiante estidianteValida = estudianteRepository.findById(id)
				.orElseThrow(() -> new RecursoNoEncontrado("ESTUDIANTE", "ID", id));

		List<Examen> lexamen = examenRepository.findAll();

		for (int o = 0; o < 4; o++) {
			for (int i = 0; i < 1; i++) {
				if (respuestasPreguntasDTO.getRespuestaPregunta1().equals(lexamen.get(0).getOpcion_correcta())) {
					porcentaje = porcentaje + 25;
				}

				if (respuestasPreguntasDTO.getRespuestaPregunta2().equals(lexamen.get(1).getOpcion_correcta())) {
					porcentaje = porcentaje + 25;
				}

				if (respuestasPreguntasDTO.getRespuestaPregunta3().equals(lexamen.get(2).getOpcion_correcta())) {
					porcentaje = porcentaje + 25;
				}
				if (respuestasPreguntasDTO.getRespuestaPregunta4().equals(lexamen.get(3).getOpcion_correcta())) {
					porcentaje = porcentaje + 25;
				}

			}
			break;
		}

		respuestasPreguntasDTO.setIdEstudiante(estidianteValida.getId());
		respuestasPreguntasDTO.setPorcentajeObtenido(String.valueOf(porcentaje));
		respuestasPreguntasDTO.setResultadoExamen(porcentaje == 100 ? "Examen aprobado" : "Examen no aprobado");

		RespuestasPreguntas respuestas = mappeaRespuestasModel(respuestasPreguntasDTO);

		RespuestasPreguntas respuestasres = recopilarRespuestasRepository.save(respuestas);
		RespuestasPreguntasDTO respuestasDTO = mappeaRespuestaDTO(respuestasres);
		return respuestasDTO;
	}

	private RespuestasPreguntasDTO mappeaRespuestaDTO(RespuestasPreguntas respuestasPreguntas) {
		RespuestasPreguntasDTO respuestasdto = new RespuestasPreguntasDTO();
		respuestasdto.setId(respuestasPreguntas.getId());
		respuestasdto.setIdEstudiante(respuestasPreguntas.getId_estudiante());
		respuestasdto.setPorcentajeObtenido(respuestasPreguntas.getPorcentaje_obtenido());
		respuestasdto.setRespuestaPregunta1(respuestasPreguntas.getRespuesta_pregunta1());
		respuestasdto.setRespuestaPregunta2(respuestasPreguntas.getRespuesta_pregunta2());
		respuestasdto.setRespuestaPregunta3(respuestasPreguntas.getRespuesta_pregunta3());
		respuestasdto.setRespuestaPregunta4(respuestasPreguntas.getRespuesta_pregunta4());
		respuestasdto.setResultadoExamen(respuestasPreguntas.getResultado_examen());

		return respuestasdto;
	}

	private RespuestasPreguntas mappeaRespuestasModel(RespuestasPreguntasDTO respuestasPreguntasDTO) {
		RespuestasPreguntas respuestas = new RespuestasPreguntas();
		respuestas.setId_estudiante(respuestasPreguntasDTO.getIdEstudiante());
		respuestas.setPorcentaje_obtenido(respuestasPreguntasDTO.getPorcentajeObtenido());
		respuestas.setRespuesta_pregunta1(respuestasPreguntasDTO.getRespuestaPregunta1());
		respuestas.setRespuesta_pregunta2(respuestasPreguntasDTO.getRespuestaPregunta2());
		respuestas.setRespuesta_pregunta3(respuestasPreguntasDTO.getRespuestaPregunta3());
		respuestas.setRespuesta_pregunta4(respuestasPreguntasDTO.getRespuestaPregunta4());
		respuestas.setResultado_examen(respuestasPreguntasDTO.getResultadoExamen());

		return respuestas;

	}
}
