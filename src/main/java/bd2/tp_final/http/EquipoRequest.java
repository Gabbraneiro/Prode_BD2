package bd2.tp_final.http;

import java.util.HashMap;
import java.util.Map;


public class EquipoRequest implements ProdeRequest{
	
	private String nombre;	
	
	public String getNombre() {
		return nombre;
	}
	
	public Map<String, Object> validarRequest(){
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
		return retorno;
		
	}

}
