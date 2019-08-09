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

import bd2.tp_final.dto.Torneo;
import bd2.tp_final.http.ProdeResponse;
import bd2.tp_final.http.TorneoRequest;

@RestController
public class TorneoController extends ProdeController{

	/* ALTA */
	@RequestMapping(value ="/torneo", method = RequestMethod.POST, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> nuevoTorneo(@RequestBody TorneoRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		
		try {
			Torneo t = torneoService.nuevoTorneo(request.getNombre());
			return new ProdeResponse(t, HttpStatus.CREATED).render();
		}
		catch(Exception e) {
			return new ProdeResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).render();
		}		
	}
	
	/* CONSULTA */
	@RequestMapping(value="/torneo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerTorneos(){
		Iterable<Torneo> torneos =  torneoService.obtenerTorneos();
		return new ProdeResponse(torneos, HttpStatus.ACCEPTED).render();
	}
	
	/* CONSULTA */
	@RequestMapping(value ="/torneo/{torneo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerTorneo(@PathVariable("torneo") Torneo torneo) {
		if(Objects.equals(torneo, null)) {
			return new ProdeResponse("Torneo no encontrado", HttpStatus.NOT_FOUND).render();
		}
		return new ProdeResponse(torneo, HttpStatus.OK).render();
	}
	
	/* MODIFICACIÓN */
	@RequestMapping(value="/torneo/{torneo}", method = RequestMethod.PATCH, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> editarUsuario(@PathVariable("torneo") Torneo torneo, @RequestBody TorneoRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		if(!Objects.equals(torneo, null)){
			String nombre = request.getNombre();
			Torneo t = torneoService.editarTorneo(torneo, nombre);
			return new ProdeResponse(t, HttpStatus.OK).render();
		}
		else {
			return new ProdeResponse("Torneo no encontrado", HttpStatus.NOT_FOUND).render();
		}

	}
	
}
