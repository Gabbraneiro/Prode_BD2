package bd2.tp_final.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import bd2.tp_final.dto.Apuesta;
import bd2.tp_final.dto.Torneo;
import bd2.tp_final.dto.Usuario;
import bd2.tp_final.http.ProdeResponse;
import bd2.tp_final.http.PuntajeResponse;
import bd2.tp_final.http.UsuarioRequest;

@RestController
public class UsuarioController extends ProdeController{
	
	/* ALTA */
	@RequestMapping(value ="/usuario", method = RequestMethod.POST, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> nuevoUsuario(@RequestBody UsuarioRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		
		try {
			Usuario u = usuarioService.nuevoUsuario(request.getUsername(), request.getNombre(), request.getApellido());
			return new ProdeResponse(u, HttpStatus.CREATED).render();	
		}
		catch(Exception e) {
			return new ProdeResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR).render();
		}		
	}
	
	/* CONSULTA */
	@RequestMapping(value="/usuario", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerUsuarios(){
		Iterable<Usuario> usuarios =  usuarioService.obtenerUsuarios();
		return new ProdeResponse(usuarios, HttpStatus.ACCEPTED).render();
	}
	
	/* CONSULTA */
	@RequestMapping(value ="/usuario/{usuario}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerUsuario(@PathVariable("usuario") Usuario usuario) {
		if(Objects.equals(usuario, null)) {
			return new ProdeResponse("Usuario no encontrado", HttpStatus.NOT_FOUND).render();
		}
		return new ProdeResponse("Usuario no encontrado", HttpStatus.NOT_FOUND).render();

	}
	
	/* CONSULTA */
	@RequestMapping(value ="/usuario/{usuario}/apuestas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerApuestas(@PathVariable("usuario") Usuario usuario) {
		Iterable<Apuesta> apuestas =  apuestaService.obtenerApuestas(usuario);
		return new ProdeResponse(apuestas, HttpStatus.ACCEPTED).render();

	}
	
	/* MODIFICACIÓN */
	@RequestMapping(value="/usuario/{usuario}", method = RequestMethod.PATCH, produces = "application/json",headers = "Accept=application/json")
	public ResponseEntity<String> editarUsuario(@PathVariable("usuario") Usuario usuario, @RequestBody UsuarioRequest request) {
		
		Map<String,Object> validacion = request.validarRequest();
		if(!(Boolean)validacion.get("requestValido")) {
			return new ProdeResponse(validacion, HttpStatus.BAD_REQUEST).render();
		}
		
		if(!Objects.equals(usuario, null)){
			Usuario u2 = usuarioService.editarUsuario(usuario, request.getUsername(), request.getNombre(), request.getApellido());
			return new ProdeResponse(u2,HttpStatus.OK).render();
		}
		else {
			return new ProdeResponse("Usuario no encontrado", HttpStatus.NOT_FOUND).render();
		}

	}
	
	/* CONSULTA */
	@RequestMapping(value="/puntajes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> obtenerPuntajes(){
		List<PuntajeResponse> puntajes = new ArrayList<PuntajeResponse>();
		Iterable<Usuario> usuarios = usuarioService.obtenerUsuarios();
		for (Usuario u : usuarios) {
			Integer puntaje =  apuestaService.obtenerPuntaje(u);
			puntajes.add(new PuntajeResponse(u.getUsername(), puntaje));
		}
		
		return new ProdeResponse(puntajes, HttpStatus.ACCEPTED).render();
	}

}
