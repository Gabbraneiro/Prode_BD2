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

import bd2.tp_final.dto.Apuesta;
import bd2.tp_final.dto.Partido;
import bd2.tp_final.dto.Usuario;
import bd2.tp_final.http.ApuestaRequest;
import bd2.tp_final.http.ProdeResponse;


@RestController
public class ApuestaController extends ProdeController{

	/* ALTA */
	@RequestMapping(value ="/apuesta", method = RequestMethod.POST, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> nuevaApuesta(@RequestBody ApuestaRequest request) {
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		try {
			Usuario usuario = usuarioService.obtenerUsuario(request.getUsuario()).get();
			Partido partido = partidoService.obtenerPartido(request.getPartido()).get();
			Apuesta a = apuestaService.nuevaApuesta(partido, usuario, request.getGolesLocal(), request.getGolesVisitante(), request.getPenalesLocal(), request.getPenalesVisitante());
			return new ProdeResponse(a, HttpStatus.CREATED).render();
		}
		catch(Exception e) {
			return new ProdeResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).render();
		}		
	}
	
	/* CONSULTA */
	@RequestMapping(value ="/apuesta/{apuesta}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerApuesta(@PathVariable("apuesta") Apuesta apuesta) {
		if(Objects.equals(apuesta, null)) {
			return new ProdeResponse("Apuesta no encontrado", HttpStatus.NOT_FOUND).render();
		}
		return new ProdeResponse(apuesta, HttpStatus.OK).render();

	}
	
	/* CONSULTA */
	@RequestMapping(value="/apuesta", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerApuestas(){
		Iterable<Apuesta> apuestas =  apuestaService.obtenerApuestas();
		return new ProdeResponse(apuestas, HttpStatus.ACCEPTED).render();
	}
	
	/* CONSULTA */
	@RequestMapping(value="/apuesta/contabilizar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> contabilizaApuestas(){
		Iterable<Apuesta> apuestas =  apuestaService.contabilizarApuestas();
		return new ProdeResponse(apuestas, HttpStatus.ACCEPTED).render();
	}
}
