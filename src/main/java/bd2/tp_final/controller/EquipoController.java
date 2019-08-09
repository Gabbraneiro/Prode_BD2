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
import bd2.tp_final.http.EquipoRequest;
import bd2.tp_final.http.ProdeResponse;

@RestController
public class EquipoController extends ProdeController{

	
	/* ALTA */
	@RequestMapping(value ="/equipo", method = RequestMethod.POST, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> nuevoEquipo(@RequestBody EquipoRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		
		try {
			Equipo e = equipoService.nuevoEquipo(request.getNombre());
			return new ProdeResponse(e, HttpStatus.CREATED).render();
		}
		catch(Exception e) {
			return new ProdeResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).render();
		}		
	}
	
	/* CONSULTA */
	@RequestMapping(value="/equipo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerEquipos(){
		Iterable<Equipo> equipos =  equipoService.obtenerEquipos();
		return new ProdeResponse(equipos, HttpStatus.ACCEPTED).render();
	}
	
	/* CONSULTA */
	@RequestMapping(value ="/equipo/{equipo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerEquipo(@PathVariable("equipo") Equipo equipo) {
		if(Objects.equals(equipo, null)) {
			return new ProdeResponse("Equipo no encontrado", HttpStatus.NOT_FOUND).render();
		}
		return new ProdeResponse(equipo, HttpStatus.OK).render();

	}
	
	/* MODIFICACIÓN */
	@RequestMapping(value="/equipo/{equipo}", method = RequestMethod.PATCH, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> editarUsuario(@PathVariable("equipo") Equipo equipo, @RequestBody EquipoRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		
		if(!Objects.equals(equipo, null)){
			String nombre = request.getNombre();
			Equipo e = equipoService.editarEquipo(equipo, nombre);
			return new ProdeResponse(e, HttpStatus.OK).render();
		}
		else {
			return new ProdeResponse("Equipo no encontrado", HttpStatus.NOT_FOUND).render();
		}

	}
	
}
