package bd2.tp_final.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bd2.tp_final.dto.Equipo;
import bd2.tp_final.dto.Partido;
import bd2.tp_final.dto.Torneo;
import bd2.tp_final.http.ActualizacionPartidoRequest;
import bd2.tp_final.http.PartidoRequest;
import bd2.tp_final.http.ProdeResponse;



@RestController
public class PartidoController extends ProdeController{

	/* ALTA */
	@RequestMapping(value ="/partido", method = RequestMethod.POST, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> nuevoPartido(@RequestBody PartidoRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		
		try {
			Equipo local = equipoService.obtenerEquipo(request.getLocal()).get();
			Equipo visitante = equipoService.obtenerEquipo(request.getVisitante()).get();
			Torneo torneo = torneoService.obtenerTorneo(request.getTorneo()).get();
			String fecha = request.getFecha();
			Partido p = partidoService.nuevoPartido(local, visitante, torneo, fecha);
			return new ProdeResponse(p, HttpStatus.CREATED).render();
		}
		catch(Exception e) {
			return new ProdeResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).render();
		}		
	}
	
	/* CONSULTA */
	@RequestMapping(value="/partido", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerPartidos(){
		Iterable<Partido> partidos =  partidoService.obtenerPartidos();
		return new ProdeResponse(partidos, HttpStatus.ACCEPTED).render();
	}
	
	/* CONSULTA */
	@RequestMapping(value ="/partido/{partido}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerPartido(@PathVariable("partido") Partido partido) {
		if(Objects.equals(partido, null)) {
			return new ProdeResponse("Partido no encontrado", HttpStatus.NOT_FOUND).render();
		}
		return new ProdeResponse(partido, HttpStatus.OK).render();
	}
	
	/* ACTUALIZACIÓN */
	@RequestMapping(value="/partido/{partido}", method = RequestMethod.PUT, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> editarUsuario(@PathVariable("partido") Partido partido, @RequestBody ActualizacionPartidoRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		
		if(!Objects.equals(partido, null)){
			Partido p = partidoService.actualizarResultadosPartido(partido, request.getGolesLocal(), request.getGolesVisitante(), request.getPenalesLocal(), request.getPenalesVisitante());
			return new ProdeResponse(p, HttpStatus.OK).render();
		}
		else {
			return new ProdeResponse("Partido no encontrado", HttpStatus.NOT_FOUND).render();
		}

	}
	
}
