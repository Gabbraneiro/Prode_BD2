package bd2.tp_final.http;

import java.util.HashMap;
import java.util.Map;

public class UsuarioRequest implements ProdeRequest{

	private String username;	

	private String nombre;	

	private String apellido;

	public String getUsername() {
		return username;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Map<String, Object> validarRequest() {
		Map<String,Object> retorno = new HashMap<String,Object>();
		retorno.put("requestValido", true);
		if(nombre == null) {
			retorno.put("nombre", "El campo nombre no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(nombre != null && nombre.isEmpty()) {
			retorno.put("nombre", "El campo nombre no puede estar vacio");
			retorno.put("requestValido", false);
		}
		if(apellido == null) {
			retorno.put("apellido", "El campo apellido no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(apellido != null && apellido.isEmpty()) {
			retorno.put("apellido", "El campo apellido no puede estar vacio");
			retorno.put("requestValido", false);
		}
		if(username == null) {
			retorno.put("username", "El campo username no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(username != null && apellido.isEmpty()) {
			retorno.put("username", "El campo username no puede estar vacio");
			retorno.put("requestValido", false);
		}
		return retorno;
	}
	
}
